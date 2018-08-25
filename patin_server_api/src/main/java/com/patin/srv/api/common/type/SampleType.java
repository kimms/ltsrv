package com.patin.srv.api.common.type;

/**
 * SampleType.java
 * 
 * @author KIM, MinSeob
 */
public enum SampleType {
	TYPE_A("typeA"){
		@Override
		public boolean getOption() {
			// TODO Auto-generated method stub
			return true;
		}
	},
	
	TYPE_B("typeB"){
		@Override
		public boolean getOption() {
			// TODO Auto-generated method stub
			return false;
		}
	},
	
	TYPE_C("typeC"){
		@Override
		public boolean getOption() {
			// TODO Auto-generated method stub
			return false;
		}
	},
	
	TYPE_D("typeD"){
		@Override
		public boolean getOption() {
			// TODO Auto-generated method stub
			return false;
		}
	},
	
	TYPE_E("typeE"){
		@Override
		public boolean getOption() {
			// TODO Auto-generated method stub
			return false;
		}
	};
	
	String type;

    SampleType(String type) {
        this.type = type;
    }
    
    public String getType() {
		return type;
	}
	
	public abstract boolean getOption();
	
}
