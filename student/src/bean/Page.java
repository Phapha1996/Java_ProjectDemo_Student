package bean;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Page {

	private final int PAGESIZE = 10;	//һҳ��ʾ��¼����Ŀ
	private List list;					//ȡ����һҳ�����ݼ���
	private int totlerecord;			//�ܼ�¼��
	private int totlepage;				//��ס��ҳ��	
	private int pagenum;				//�����û��뿴��ҳ
	private int startindex;				//�����û��뿴��ҳ�ô����ݿ���ĸ�λ�ÿ�ʼȡ
	private int startpage;				//��סjspҳ����ʾ�Ŀ�ʼҳ��
	private int endpage;				//��סjspҳ����ʾ�Ľ���ҳ��
	
	public Page(int totlerecord,int pagenum){
		this.totlerecord = totlerecord;
		this.pagenum = pagenum;
		if(totlerecord%PAGESIZE==0)
			this.totlepage = this.totlerecord/PAGESIZE;
		else{
			this.totlepage = this.totlerecord/PAGESIZE+1;
		}
		
		this.startindex = (pagenum-1)*PAGESIZE; 		//������ĸ�λ�ÿ�ʼȡ����
		
		//�����û���������pagenum�����jsp��ʼҳ�������ҳ��
		if(totlepage<10){							//���ֻ��ʮҳ���ڡ����ù���
			this.startpage = 1;
			this.endpage = this.totlepage;			
		}else{										//���ǳ���ʮҳ�Ժ��Ҫ������
			this.startpage = pagenum-4;
			this.endpage = pagenum+5;
			
			if(this.startpage<1){				//���������ǰ��������startpage���2��������ô�����ֽ�������
				this.startpage = 1;
				this.endpage = 10;
			}
			
			if(this.endpage>this.totlepage){			//��������������endpage��������ҳ����Χ����ô��endpage��������Ϊ���ֵ
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
