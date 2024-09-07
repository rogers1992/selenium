package introduction.streamsregularexpretions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;



public class Test1 {
	public void regular() 
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Roger");
		names.add("Theoden");
		names.add("Don");
		names.add("Daniel");
		names.add("Gabriel");
		int count = 0;
		
		for(int i=0 ; i<names.size(); i++) 
		{
			String actual = names.get(i);
			if(actual.startsWith("T")) 
			{
				count++;
			}
		}
	}
	public void streamFilter()
	{ 
		ArrayList<String> names = new ArrayList<String>();
		names.add("Roger");
		names.add("Theoden");
		names.add("Don");
		names.add("Daniel");
		names.add("Gabriel");
		
		//There is no life for intermediate operation if there is no terminal operation
		//Terminal operation will execute onlhy if intermediate operation (filter) returns true
		//we can create stream
		//how to use filter in stream API 
		Long count = names.stream().filter(s->s.startsWith("D")).count();
		System.out.println(count);
		
		Long c = Stream.of("Roger","Theoden", "Don", "Daniel").filter(s->
		{
			s.startsWith("D");
			return false;
		}).count();
		
		//Print all names of ArrayList with stream
		
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s ));
	}	
	public void streamMap() 
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Roger");
		names.add("Theoden");
		names.add("Don");
		names.add("Daniel");
		names.add("Gabriel");
		
		Stream.of("Roger","Theoden", "Don", "Daniel").filter(s->s.endsWith("n")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		List<String> names1 = Arrays.asList("Roger","Theoden", "Don", "Daniel");
		names1.stream().filter(s->s.startsWith("a")).sorted().map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		//merging 2 diferents list
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		newStream.sorted().forEach(s->System.out.println(s));
		
		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
		Assert.assertTrue(flag);
	}
	
	public void streamCollect() 
	{
		List<String> ls = Stream.of("Roger","Theoden", "Don", "Daniel").filter(s->s.endsWith("n")).map(s->s.toUpperCase())
		.collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
		values.stream().distinct().forEach(s->System.out.println(s));
		List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(2));
	}
}
