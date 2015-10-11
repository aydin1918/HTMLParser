/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmlparser;

/**
 *
 * @author admin
 */
public class Data {
	 private int ID;
	 private int sechkiID;
	 private int pageID;
	 private String name; //four
	 private String address; //five
	 private int year;
	 private String IDstring; //first
	 private String sechkiIDstring; //second
	 private String pageIDstring; //three
	 private String yearString; //six
	   
	    public void setID(int ID){ //Выбираем ID
	    	this.ID = ID; 
	    } 
	    
	    public int getID(){ //Задаем ID
	    	return ID;
	    }
	    
	    public void setSechkiID(int sechkiID){
	    	this.sechkiID = sechkiID;
	    }
	    
	    public int getSechkiID(){
	    	return sechkiID;
	    }

		public int getPageID() {
			return pageID;
		}

		public void setPageID(int pageID) {
			this.pageID = pageID;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}
	    
		public String getIDstring(){
	    	return IDstring;
	    }
		
	    public void setIDstring(String IDstring){
	    	this.IDstring = IDstring;
	    }
	    
	    

		public String getSechkiIDstring() {
			return sechkiIDstring;
		}

		public void setSechkiIDstring(String sechkiIDstring) {
			this.sechkiIDstring = sechkiIDstring;
		}

		public String getPageIDstring() {
			return pageIDstring;
		}

		public void setPageIDstring(String pageIDstring) {
			this.pageIDstring = pageIDstring;
		}

		public String getYearString() {
			return yearString;
		}

		public void setYearString(String yearString) {
			this.yearString = yearString;
		}
}

