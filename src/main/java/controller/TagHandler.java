package controller;

	import java.util.Calendar;
import java.util.TimeZone;

import javax.servlet.jsp.JspException;  
	import javax.servlet.jsp.JspWriter;  
	import javax.servlet.jsp.tagext.TagSupport;  
	public class TagHandler extends TagSupport{  
	  
	public int doStartTag() throws JspException {  
	    JspWriter out=pageContext.getOut();//returns the instance of JspWriter 
		
	    try{  
	    out.print(Calendar.getInstance().getTime());//printing date and time using JspWriter  
	     /*Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("EST"));
			long time = System.nanoTime();
			out.print(time);*/
	    }catch(Exception e){System.out.println(e);}  
	    return SKIP_BODY;//will not evaluate the body content of the tag  
	}  
	}  


