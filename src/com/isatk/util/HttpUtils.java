package com.isatk.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isatk.ge.utils.JsonConverter;
import com.isatk.ge.utils.code.CodeCreater;

public class HttpUtils {
	private static int BUFFER=1024;
	private static String HOST = "http://127.0.0.1";
	
	private Map<String,Object> params = new HashMap<String,Object>();
	
	public HttpUtils addPaprm(String key,Object o){
		params.put(key, o);
		return this;
	}

	public String send(String url,String token,Object o){
		if(!url.startsWith("/")&&!url.startsWith("http"))
			url="/"+url;
		return postForm(url,token,o==null?params:o);
	}
	public HttpUtils clear(){
		params = new HashMap<String,Object>();
		return this;
	}
	/**
	 * 发送 get请求
	 */
	private String httpGet(String url,Header[] headers) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			// 创建httpget.
			HttpGet httpget = new HttpGet(url);
			httpget.setHeaders(headers);
			// 执行get请求.
			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				// 获取响应实体
				HttpEntity entity = response.getEntity();
				// 打印响应状态
				if (entity != null) {
					return EntityUtils.toString(entity);
				}
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 下载文件
	 * 
	 * @param url
	 *            下载路径
	 * @param filePath
	 *            文件存放路径
	 * @return 返回磁盘文件
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	private  File downloadFile(String url, String filePath, int num)
			throws ClientProtocolException, IOException {
		num--;
		String fileName = url.substring(url.lastIndexOf("."), url.length());
		File file = new File(filePath + CodeCreater.getDBID() + fileName);
		HttpEntity entity = null;
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpget = new HttpGet(url);
			HttpResponse response = httpclient.execute(httpget);
			entity = response.getEntity();
		} catch (Exception e) {
			if (num == 0) {
				return null;
			} else {
				downloadFile(url, filePath, num);
			}
		}

		if (entity != null) {
			// long len = entity.getContentLength();
			InputStream inputStream = entity.getContent();
			FileOutputStream out = new FileOutputStream(file);
			byte[] b = new byte[BUFFER];
			int len = 0;
			while ((len = inputStream.read(b)) != -1) {
				out.write(b, 0, len);
			}
			inputStream.close();
			out.close();
		}
		return file;
	}

	/*private String postForm(String url, String token) {
		return postForm(url,token,params);
	}*/
	/**
	 * post方式提交表单
	 */
	private String postForm(String url, String token,Object o) {
		// 创建默认的httpClient实例.
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建httppost
		HttpPost httppost = new HttpPost(url);
		try {
			ObjectMapper jm = JsonConverter.getMapper();
			System.out.println(jm.writeValueAsString(o));
			httppost.setEntity(new StringEntity(jm.writeValueAsString(o), "utf-8"));
			CloseableHttpResponse response = httpclient.execute(httppost);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					return EntityUtils.toString(entity, "UTF-8");
				}
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
