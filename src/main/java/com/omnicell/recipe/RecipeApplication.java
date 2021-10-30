package com.omnicell.recipe;

import com.omnicell.recipe.entity.Recipe;
import com.omnicell.recipe.repo.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
@EnableCaching
public class RecipeApplication {

	@Autowired
	private RecipeRepo recipeRepo;

	public static void main(String[] args) {
		SpringApplication.run(RecipeApplication.class, args);
	}

	@PostConstruct
	public void insertData() {
		recipeRepo.saveAllAndFlush(
				Arrays.asList(
						new Recipe(0,"Uthappizza","https://i.imgur.com/tDnjTXf.jpg","mains","Hot",4.99,"A unique combination of Indian Uthappam (pancake) and Italian pizza"),
						new Recipe(1,"Zucchipakoda","https://i.imgur.com/xkUElXq.jpg","appetizer",null,1.99,"Deep fried Zucchini coated with mildly spiced Chickpea flour batter accompanied with a sweet-tangy tamarind sauce"),
						new Recipe(2,"Vadonut","https://i.imgur.com/anUAlqF.jpg","appetizer","New",1.99,"A quintessential ConFusion experience, is it a vada or is it a donut?"),
						new Recipe(3,"ElaiCheese Cake","https://i.imgur.com/c5hBTEW.jpg","dessert",null,2.99,"A delectable, semi-sweet New York Style Cheese Cake, with Graham cracker crust and spiced with Indian cardamoms"),
						new Recipe(4,"Guntur chillies","https://i.imgur.com/Vc9JIXP.jpg","appetizer","Spicy",0.99,"Assorted chillies from Guntur"),
						new Recipe(5,"Buffalo Paneer","https://i.imgur.com/pH2tkgk.jpg","appetizer",null,5.99,"A special type of Paneer made from Buffalo milk"),
						new Recipe(6,"Cherry Tomatoes","https://i.imgur.com/fRy8hjE.jpg","clone","clone",9.99,"clone of cherry and tomato"),
						new Recipe(7,"Goat Milk","https://i.imgur.com/zFGPhrI.jpg","weird","weird",1.99,"Medicinal Goat Milk"),
						new Recipe(8,"Rose breasted Grosbeak chicken","https://i.imgur.com/RYsqgoo.jpg","appetizer","New",7.99,"Roasted rare bird"),
						new Recipe(9,"Toenail Zingy","https://i.imgur.com/IpG3YOT.jpg","appetizer","weird",0.99,"Cooked Toenails of various animals")
				)
		);
	}

}
