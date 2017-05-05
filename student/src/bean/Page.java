package bean;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Page {

	private final int PAGESIZE = 10;	//一页显示记录的数目
	private List list;					//取到的一页的数据集合
	private int totlerecord;			//总记录数
	private int totlepage;				//记住总页数	
	private int pagenum;				//代表用户想看的页
	private int startindex;				//代表用户想看的页该从数据库的哪个位置开始取
	private int startpage;				//记住jsp页面显示的开始页码
	private int endpage;				//记住jsp页面显示的结束页码
	
	public Page(int totlerecord,int pagenum){
		this.totlerecord = totlerecord;
		this.pagenum = pagenum;
		if(totlerecord%PAGESIZE==0)
			this.totlepage = this.totlerecord/PAGESIZE;
		else{
			this.totlepage = this.totlerecord/PAGESIZE+1;
		}
		
		this.startindex = (pagenum-1)*PAGESIZE; 		//计算从哪个位置开始取出来
		
		//根据用户传过来的pagenum，算出jsp开始页码跟结束页码
		if(totlepage<10){							//如果只有十页以内。不用滚动
			this.startpage = 1;
			this.endpage = this.totlepage;			
		}else{										//但是超过十页以后就要滚动了
			this.startpage = pagenum-4;
			this.endpage = pagenum+5;
			
			if(this.startpage<1){				//但是如果往前滚动导致startpage变成2负数，那么对它又进行重置
				this.startpage = 1;
				this.endpage = 10;
			}
			
			if(this.endpage>this.totlepage){			//如果往后滚动导致endpage超出了总页数范围，那么对endpage进行重置为最大值
				this.startpage = this.totlepage-9;
				this.endpage = this.totlepage;
			}
		}
	}
	
	
	public List getList() {
		return list;
	}
	
	
	public void setList(List<Student> list) {
		this.list = list;
		Collections.sort(list, new Comparator<Student>(){
			public int compare(Student s1,Student s2){
				if(Integer.parseInt(s1.getNum())>Integer.parseInt(s2.getNum())){
					return 1;
				}
				if(Integer.parseInt(s1.getNum())==Integer.parseInt(s2.getNum())){
					return 0;
				}
				return -1;
			}
			
			
		});
	}
	
	
	public int getTotlerecord() {
		return totlerecord;
	}
	
	
	public void setTotlerecord(int totlerecord) {
		this.totlerecord = totlerecord;
	}
	
	
	public int getTotlepage() {
		return totlepage;
	}
	
	
	public void setTotlepage(int totlepage) {
		this.totlepage = totlepage;
	}
	
	
	public int getPAGESIZE() {
		return PAGESIZE;
	}


	public int getPagenum() {
		return pagenum;
	}


	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}


	public int getStartindex() {
		return startindex;
	}


	public void setStartindex(int startindex) {
		this.startindex = startindex;
	}


	public int getStartpage() {
		return startpage;
	}


	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}


	public int getEndpage() {
		return endpage;
	}


	public void setEndpage(int endpage) {
		this.endpage = endpage;
	}
	
}
