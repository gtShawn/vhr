package com.shawn.vhr;

import com.shawn.vhr.mapper.PositionMapper;
import com.shawn.vhr.model.Menu;
import com.shawn.vhr.model.Position;
import com.shawn.vhr.service.MenuService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionUtils;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class VhrApplicationTests {

	@Autowired
	MenuService menuService;

	@Test
	public String contextLoads() {
		List<Menu> menusByHrId = menuService.getMenusByHrId();
		return "ok";
	}

	@Test
	public void charSet()
	{
		int m[]=new int[]{1,2,3};
		int n[]= new int[3];
		for (int i = 0; i < m.length; i++) {
			n[2-i] = m[i];
		}
		System.out.println(Arrays.toString(n));
	}

	@Test
	public void  StringBuffer()
	{
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("asdasda").reverse();
		System.out.println(stringBuffer);
	}

	public int f(int n)
	{
		if (n<1)
		{
			throw new IllegalArgumentException(n+"不能小于1");
		}
		if (n==1||n==2)
		{
			return n;
		}
		return f(n-1)+f(n-2);
	}

	@Test
	public void m()
	{
		System.out.println(f(3));

	}

	@Test
	public void test1()
	{
		int i=1;
		i=i++;
		int j=i++;
		int k = i+ ++i *i++;
		System.out.println("i="+i);
		System.out.println("j="+j);
		System.out.println("k="+k);
	}

	@Test
	public void test2(){
	    int [] array1 = new int[]{1,2,3,4,5,6,8,9,11,15,86};
	    int [] array2 = new int[]{1,2,3,86,5,6,9,8,30,15,8,15,4};
        //int i = binarySort(array1, 86);
        System.out.println(Arrays.toString(maopaoSorta(array2)));
        //System.out.println(i);
    }

    //冒泡排序
    public static int[] maopaoSort(int [] array){
	    int temp =0;
	    for (int i=0;i<array.length;i++){
	        for (int j=0;j<array.length-1-i;j++){
	            if (array[j]<array[j+1]){
	                temp=array[j];
	                array[j]=array[j+1];
	                array[j+1]=temp;
                }
            }
        }
        return array;
    }

    //二分查找法
	public static int binarySort(int[] array,int i)
    {
        int low = 0;
        int high = array.length-1;
        while (low<=high){
            int mid = (low+high)/2;
            if (i<array[mid]){
                high=mid-1;
            }else if (i>array[mid]){
                low=mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    @Test
    public void index(){
		String s="index.html";
		String a=s.substring(s.lastIndexOf("."));
		System.out.println(a);
	}

	@Test
	public void uuid(){
		String m = UUID.randomUUID().toString().replaceAll("-","");
		System.out.println(m);
	}

	public static int Sort(int [] array,int key){
		int low =0;
		int high=array.length-1;
		while (low<=high){
			int mid = (low+high)/2;
			if (array[mid]>key){
				low=mid+1;
			}else if (array[mid]<key){
				high=mid-1;
			}else {
				return mid;
			}
		}
		return -1;
	}

	public static int[] maopaoSorta(int [] array){
		int temp = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j]>array[j+1]){
					temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
		return array;
	}
}
