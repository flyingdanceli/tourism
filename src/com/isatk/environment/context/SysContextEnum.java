package com.isatk.environment.context;

public class SysContextEnum {
	
public enum ClientTypeEnum{
	
	mo("MO","MO","移动端",1),
	web("WEB","WEB","网页",2);
	
	private String key;
	private String value;
	private String text;
	private int numeric;
	
	ClientTypeEnum()
	{
		
	}
	
	ClientTypeEnum(String k,String v,String t,int n)
	{
		this.key=k;
		this.value=v;
		this.text=t;
		this.numeric=n;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getNumeric() {
		return numeric;
	}

	public void setNumeric(int numeric) {
		this.numeric = numeric;
	}
	
	public boolean equals(ClientTypeEnum en) {		
		return (en.getNumeric()*1==this.getNumeric()*1)?true:false;
	}
	
	public boolean equals(int c) {		
		return (c==this.getNumeric()*1)?true:false;
	}
	
	public boolean equals(String key) {	
		if(this.getKey().equals(key))
		{
			return true;
		}
		return false;
	}
	
	public static ClientTypeEnum get(int c)
	{
		switch (c) 
		{
			case 1:return ClientTypeEnum.mo;
			case 2:return ClientTypeEnum.web;
		}
		return null;
	}
	
	
}
	
public enum WorkClassEnum{
		
		cs("CS","1","测试",1),
		ex("EX","0","练习",0);
		
		private String key;
		private String value;
		private String text;
		private int numeric;
		
		WorkClassEnum()
		{
			
		}
		
		WorkClassEnum(String k,String v,String t,int n)
		{
			this.key=k;
			this.value=v;
			this.text=t;
			this.numeric=n;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public int getNumeric() {
			return numeric;
		}

		public void setNumeric(int numeric) {
			this.numeric = numeric;
		}
		
		public boolean equals(WorkClassEnum en) {		
			return (en.getNumeric()*1==this.getNumeric()*1)?true:false;
		}
		
		public boolean equals(int c) {		
			return (c==this.getNumeric()*1)?true:false;
		}
		
		public static WorkClassEnum get(int c)
		{
			switch (c) 
			{
				case 1:return WorkClassEnum.cs;
				case 2:return WorkClassEnum.ex;
			}
			return null;
		}
		
	}
	
	public enum QueSrcEnum{
		
		zt("ZT","1","真题",1),
		org("ORG","2","官方",2),
		custom("CUSTOM","3","自编",3),
		every("EVERY","4","每日一练",4);
		
		private String key;
		private String value;
		private String text;
		private int numeric;
		
		QueSrcEnum()
		{
			
		}
		
		QueSrcEnum(String k,String v,String t,int n)
		{
			this.key=k;
			this.value=v;
			this.text=t;
			this.numeric=n;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public int getNumeric() {
			return numeric;
		}

		public void setNumeric(int numeric) {
			this.numeric = numeric;
		}
		
		public boolean equals(QueSrcEnum en) {		
			return (en.getNumeric()*1==this.getNumeric()*1)?true:false;
		}
		
		public boolean equals(int c) {		
			return (c==this.getNumeric()*1)?true:false;
		}
		
		public static QueSrcEnum get(int c)
		{
			switch (c) 
			{
				case 1:return QueSrcEnum.zt;
				case 2:return QueSrcEnum.org;
				case 3:return QueSrcEnum.custom;
				case 4:return QueSrcEnum.every;
			}
			return null;
		}
		
	}
	
	public enum QueTypeEnum{
		
		one("TIAN_KONG","1","填空",1),two("XUAN_ZHE","2","选择",2),three("XIE_ZUO","3","写作",3);
		
		private String key;
		private String value;
		private String text;
		private int numeric;
		
		QueTypeEnum()
		{
			
		}
		
		QueTypeEnum(String k,String v,String t,int n)
		{
			this.key=k;
			this.value=v;
			this.text=t;
			this.numeric=n;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public int getNumeric() {
			return numeric;
		}

		public void setNumeric(int numeric) {
			this.numeric = numeric;
		}
		
		public boolean equals(QueTypeEnum en) {		
			return (en.getNumeric()*1==this.getNumeric()*1)?true:false;
		}
		
		public boolean equals(int c) {		
			return (c==this.getNumeric()*1)?true:false;
		}
		
		public static QueTypeEnum get(int c)
		{
			switch (c) 
			{
				case 1:return QueTypeEnum.one;
				case 2:return QueTypeEnum.two;
				case 3:return QueTypeEnum.three;
			}
			return null;
		}
		
	}
		
		
		public enum QueSubjectEnum{
			
			M("M","M","数学",1),W("W","W","写作",2),R("R","R","阅读",3),E("E","E","作文",4),N("N","N","自定义",5);
			
			private String key;
			private String value;
			private String text;
			private int numeric;
			
			QueSubjectEnum()
			{
				
			}
			
			QueSubjectEnum(String k,String v,String t,int n)
			{
				this.key=k;
				this.value=v;
				this.text=t;
				this.numeric=n;
			}

			public String getKey() {
				return key;
			}

			public void setKey(String key) {
				this.key = key;
			}

			public String getValue() {
				return value;
			}

			public void setValue(String value) {
				this.value = value;
			}

			public String getText() {
				return text;
			}

			public void setText(String text) {
				this.text = text;
			}

			public int getNumeric() {
				return numeric;
			}

			public void setNumeric(int numeric) {
				this.numeric = numeric;
			}
			
			public boolean equals(QueSubjectEnum en) {		
				return (en.getNumeric()*1==this.getNumeric()*1)?true:false;
			}
			
			public boolean equals(int c) {		
				return (c==this.getNumeric()*1)?true:false;
			}
			
			public boolean equals(String c) {		
				return (this.getKey().equals(c))?true:false;
			}
			
			public static QueSubjectEnum get(int c)
			{
				switch (c) 
				{
					case 1:return QueSubjectEnum.M;
					case 2:return QueSubjectEnum.W;
					case 3:return QueSubjectEnum.R;
					case 4:return QueSubjectEnum.E;
				}
				return null;
			}
		
	}
		
		public enum BizModelEnum {
			
			exEveryDay("EX_EVERYDAY","25","每日一练",25,""),
			exErrorCorrection("EX_ERROR","24","错题练习",24,""),
			exCustomChoose("EX_CHOOSE","23","自选练习",23,""),
			exAthena("EX_ATHENA","22","智能练习",22,""),
			exActualCombat("EX_AC","21","真题练习",21,""),
			
			csCustomChoose("CS_CHOOSE","15","自选模考",15,""),
			csAthenaWrite("CS_ATHENA_W","14","阅读测试",14,""),
			csAthenaRead("CS_ATHENA_R","13","阅读测试",13,""),
			csAthenaMath("CS_ATHENA_M","12","阅读测试",12,""),
			csActualCombat("CS_AC","11","全套模考",11,""),
			csAthena("CS_ATHENA","10","智能测试",10,"");
						
			private String key;
			private String value;
			private String text;
			private int numeric;
			private String content;
						
			BizModelEnum()
			{
				
			}
			
			BizModelEnum(String k,String v,String t,int n,String c)
			{
				this.key=k;
				this.value=v;
				this.text=t;
				this.numeric=n;
				this.content=c;
			}

			public String getKey() {
				return key;
			}

			public void setKey(String key) {
				this.key = key;
			}

			public String getValue() {
				return value;
			}

			public void setValue(String value) {
				this.value = value;
			}

			public String getText() {
				return text;
			}

			public void setText(String text) {
				this.text = text;
			}

			public int getNumeric() {
				return numeric;
			}

			public void setNumeric(int numeric) {
				this.numeric = numeric;
			}
			
			
			
			public String getContent() {
				return content;
			}

			public void setContent(String content) {
				this.content = content;
			}

			public boolean equals(BizModelEnum en) {		
				return (en.getNumeric()*1==this.getNumeric()*1)?true:false;
			}
			
			public boolean equals(int c) {		
				return (c==this.getNumeric()*1)?true:false;
			}
			
			public static boolean hasIn(int c)
			{
				switch (c) 
				{
					case 25:return true;
					case 24:return true;
					case 23:return true;
					case 22:return true;
					case 21:return true;
					
					case 15:return true;
					case 14:return true;
					case 13:return true;
					case 12:return true;
					case 11:return true;
					case 10:return true;
					default : return false;
				}
			}
			
			public static boolean hasInEx(int c)
			{
				switch (c) 
				{
					case 25:return true;
					case 24:return true;
					case 23:return true;
					case 22:return true;
					case 21:return true;
					default : return false;
				}
			}
			
			public static boolean hasInCs(int c)
			{
				switch (c) 
				{
					case 15:return true;
					case 14:return true;
					case 13:return true;
					case 12:return true;
					case 11:return true;
					case 10:return true;
					default : return false;
				}
			}
			
			public static BizModelEnum get(int c)
			{
				switch (c) 
				{
					case 25:return BizModelEnum.exEveryDay;
					case 24:return BizModelEnum.exErrorCorrection;
					case 23:return BizModelEnum.exCustomChoose;
					case 22:return BizModelEnum.exAthena;
					case 21:return BizModelEnum.exActualCombat;
					
					case 15:return BizModelEnum.csCustomChoose;
					case 14:return BizModelEnum.csAthenaWrite;
					case 13:return BizModelEnum.csAthenaRead;
					case 12:return BizModelEnum.csAthenaMath;
					case 11:return BizModelEnum.csActualCombat;
					case 10:return BizModelEnum.csAthena;
				}
				return null;
			}
		}

}
