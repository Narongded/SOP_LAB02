package maven.shoes.lab01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class ShowShoes {
	private addidass addi = new addidass("addidass",500);
	private Nike nike = new Nike("Nike",1000);
	private vans vans = new vans("vans",2000);
	vatSingleton instance = new vatSingleton().getInstance();
@RequestMapping("index/addi")
private String addidass() {
	instance.setVat(addi.getPrice());
	return "Your Band "+" "+addi.getBand()+"\n"+"Price"+(instance.getVat());
	}

@RequestMapping("index/nike")
private String nike() {
	instance.setVat(nike.getPrice());
	return "Your Band "+" "+nike.getBand()+"\n"+"Price"+instance.getVat();
	}
@RequestMapping("index/vans")
private String vans() {
	instance.setVat(vans.getPrice());
	return "Your Band "+" "+vans.getBand()+"\n"+"Price"+instance.getVat();
	}
@RequestMapping(value="index/add-{band}-{price}",method = RequestMethod.GET)
private String add(@PathVariable("band") String band,@PathVariable("price") int price) throws IOException{
		FileWriter w = new FileWriter("output.txt");
		instance.setVat(price);
		w.write("band :"+band+" price :"+instance.getVat()+"\n");
		w.close();
	return String.format("add band %s price %d", band,instance.getVat());
	}
@RequestMapping("index/showadd")
private String showadd() {
	try {
		FileReader r = new FileReader("output.txt");
		int data;
		while((data = r.read()) != -1) {
			System.out.printf("%c", data);
			
		}
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "Read you Console";
	}
}
