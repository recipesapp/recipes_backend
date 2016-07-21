package org.chereshka.recipes.backend.resources;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.chereshka.recipes.backend.model.Category;
import org.chereshka.recipes.backend.model.Nutrient;
import org.chereshka.recipes.backend.model.Person;
import org.chereshka.recipes.backend.model.Recipe;
import org.chereshka.recipes.backend.model.Type;
import org.chereshka.recipes.backend.persistence.PersonDao;
import org.chereshka.recipes.backend.persistence.RecipesDao;

@Path("/test")
public class AddExampleResources {

	// private List<Comment> comments() {
	// final List<Comment> comments = new LinkedList<Comment>();
	// Comment comment = null;
	// {
	// comment = new Comment();
	// comment.setComments("Vkusna supa");
	// comment.setDate(new Date());
	// comment.setStarRating(3.5);
	// final Person pesho = new Person();
	// pesho.setName("Pesho");
	// comment.setUser(pesho);
	// comments.add(comment);
	// }
	// {
	// comment = new Comment();
	// comment.setComments("Vkusna mandja");
	// comment.setDate(new Date());
	// comment.setStarRating(1.5);
	// final Person doncho = new Person();
	// doncho.setName("Pesho");
	// comment.setUser(doncho);
	// comments.add(comment);
	// }
	// return comments;
	// }

	// private List<Allergens> allergens() {
	// final List<Allergens> allergens = new LinkedList<Allergens>();
	// Allergens allergen = null;
	// {
	// allergen = new Allergens();
	// allergen.setName("Kislorod");
	// allergens.add(allergen);
	// }
	// {
	// allergen = new Allergens();
	// allergen.setName("Kopriva");
	// allergens.add(allergen);
	// }
	// return allergens;
	// }

	// gotovo?
	private Recipe recipeMusaka() {
		final Recipe musaka = new Recipe();
		musaka.setCategory(Category.MAIN);
		musaka.setIngredients(musakaIngredients());
		// musaka.setInstructions("Obelvate i narqzvate kartofite na kubcheta. Postavqte gi v dulboka tava. Na predvaritelno zagrqt tigan zapurjvate luka i kaimata. Dobavqte domatenoto piure, sol i cheren piper na vkus i zapurjvate za oshte nqkolko minuti (3-5). Dobavqte kum tavata s kartofite, razburkvate i slagate v predvaritelno zagrqta furna na 200-250 gradusa. Sled kato kartofite pridobiqt kafenikav ten zalivate sus zalivkata i dopichate. Prigotvqne na zalivkata: razbivate dobre qicata, sled kato sa dobre razbiti pribavqme kiseloto mlqko. Razkurkvate dobre. Ako e mnogo gusta moje da dobavite voda.");
		musaka.setName("Musaka");
		musaka.setServings(5d);
		musaka.setTimeToCookMinutes(90d);
		musaka.setType(Type.NORMAL);
		return musaka;
	}

	// gotovo?
	private Recipe recipeOrizSMeso() {
		final Recipe orizSMeso = new Recipe();
		orizSMeso.setCategory(Category.MAIN);
		orizSMeso.setIngredients(orizSMesoIngredients());
		// orizSMeso
		// .setInstructions("Svinskoto meso se narqzva na kubcheta i se zapurjva v malko olio. Dobavqt se narqzanite sitno luk i nasturganiqt morkov. Posolqva se, dobavq se voda i se ostavq da vri do gotovnost. Dobavq se orizut,ovkusq se s podpravki i se prehvurlq v namaslena tava. Zapicha se v umerena furna do poemane na vodata ot oriza.");
		orizSMeso.setName("Oriz s meso");
		orizSMeso.setServings(6d);
		orizSMeso.setTimeToCookMinutes(90d);
		orizSMeso.setType(Type.NORMAL);
		return orizSMeso;
	}

	private List<Nutrient> orizSMesoIngredients() {
		List<Nutrient> ingredients = new LinkedList<Nutrient>();
		Nutrient nutrient = null;
		{
			nutrient = new Nutrient();
			nutrient.setName("Svinsko meso - 1 kg");
			ingredients.add(nutrient);
		}
		{
			nutrient = new Nutrient();
			nutrient.setName("Oriz - 1 ch. ch.");
			ingredients.add(nutrient);
		}
		{
			nutrient = new Nutrient();
			nutrient.setName("Luk- 1 glava");
			ingredients.add(nutrient);
		}
		{
			nutrient = new Nutrient();
			nutrient.setName("Olio - 100 ml");
			ingredients.add(nutrient);
		}
		{
			nutrient = new Nutrient();
			nutrient.setName("Chubrica - 1 k. ch.");
			ingredients.add(nutrient);
		}
		{
			nutrient = new Nutrient();
			nutrient.setName("Cheren piper - 3 shtipki");
			ingredients.add(nutrient);
		}
		{
			nutrient = new Nutrient();
			nutrient.setName("Sol - 1 ch. l.");
			ingredients.add(nutrient);
		}
		{
			nutrient = new Nutrient();
			nutrient.setName("Morkovi - 2");
			ingredients.add(nutrient);
		}
		return ingredients;
	}

	// gotovo?
	private Recipe recipeSpaghetti() {
		final Recipe spaghetti = new Recipe();
		spaghetti.setCategory(Category.MAIN);
		spaghetti.setIngredients(spaghettiIngredients());
		// spaghetti
		// .setInstructions("Spagetite se varqt v podsolena voda, kogato sa gotovi se otcejdat. V tendjerka se zapurjva lukut do zlatisto, posle se dobavq natroshenata kaima. Dobavqt se podpravkite i se razburkvat. Domatite se obelvat i se nasturgvat pri kaimata. Burka se i se vari do sgustqvane. Spagetite se zalivat sus sosa i se servirat.");
		spaghetti.setName("Spaghetti");
		spaghetti.setServings(1d);
		spaghetti.setTimeToCookMinutes(30d);
		spaghetti.setType(Type.NORMAL);
		return spaghetti;
	}

	private List<Nutrient> spaghettiIngredients() {
		List<Nutrient> ingredients = new LinkedList<Nutrient>();
		Nutrient nutrient = null;
		{
			nutrient = new Nutrient();
			nutrient.setName("Spageti - 1 paket");
			ingredients.add(nutrient);
		}
		{
			nutrient = new Nutrient();
			nutrient.setName("Voda - da pokrie spagetite");
			ingredients.add(nutrient);
		}
		{
			nutrient = new Nutrient();
			nutrient.setName("Kaima - 250 g");
			ingredients.add(nutrient);
		}
		{
			nutrient = new Nutrient();
			nutrient.setName("Luk - 1 glava");
			ingredients.add(nutrient);
		}
		{
			nutrient = new Nutrient();
			nutrient.setName("Domati - 2 broq");
			ingredients.add(nutrient);
		}
		{
			nutrient = new Nutrient();
			nutrient.setName("Cherven piper - na vkus");
			ingredients.add(nutrient);
		}
		{
			nutrient = new Nutrient();
			nutrient.setName("Cheren piper - na vkus");
			ingredients.add(nutrient);
		}
		{
			nutrient = new Nutrient();
			nutrient.setName("Rigan - na vkus");
			ingredients.add(nutrient);
		}
		{
			nutrient = new Nutrient();
			nutrient.setName("Bosilek - na vkus");
			ingredients.add(nutrient);
		}
		{
			nutrient = new Nutrient();
			nutrient.setName("Sol - na vkus");
			ingredients.add(nutrient);
		}
		return ingredients;
	}

	private List<Nutrient> musakaIngredients() {
		List<Nutrient> ingredients = new LinkedList<Nutrient>();
		Nutrient nutrient = null;
		{
			nutrient = new Nutrient();
			nutrient.setName("Kartofi - 1.5-2 kg");
			ingredients.add(nutrient);
		}
		{
			nutrient = new Nutrient();
			nutrient.setName("Luk - 1 glava");
			ingredients.add(nutrient);
		}
		{
			nutrient = new Nutrient();
			nutrient.setName("Qica - 2-3 (za zalivkata)");
			ingredients.add(nutrient);
		}
		{
			nutrient = new Nutrient();
			nutrient.setName("Brashno - 1 s.l. (za zalivkata)");
			ingredients.add(nutrient);
		}
		{
			nutrient = new Nutrient();
			nutrient.setName("Maslo - 30 g");
			ingredients.add(nutrient);
		}
		{
			nutrient = new Nutrient();
			nutrient.setName("Domateno piure - 150-200 ml");
			ingredients.add(nutrient);
		}
		{
			nutrient = new Nutrient();
			nutrient.setName("Kiselo mlqko - 1 kofichka");
			ingredients.add(nutrient);
		}
		{
			nutrient = new Nutrient();
			nutrient.setName("Kaima - 500 g");
			ingredients.add(nutrient);
		}
		{
			nutrient = new Nutrient();
			nutrient.setName("Cheren piper - na vkus");
			ingredients.add(nutrient);
		}
		{
			nutrient = new Nutrient();
			nutrient.setName("Sol - na vkus");
			ingredients.add(nutrient);
		}
		{
			nutrient = new Nutrient();
			nutrient.setName("Voda - 150 ml (za zalivkata)");
			ingredients.add(nutrient);
		}
		return ingredients;
	}

	// gotovo
	List<Recipe> favorites() {
		final List<Recipe> favorites = new LinkedList<Recipe>();
		favorites.add(this.recipeMusaka());
		favorites.add(this.recipeSpaghetti());
		return favorites;
	}

	private Person Loren() {
		final Person Loren = new Person();
		Loren.setId(100l);
		Loren.setAge(21);
		Loren.setFavorites(this.favorites());
		Loren.setHashAuth("123456");
		Loren.setHeight(178.50);
		Loren.setName("Loren");
		Loren.setUserInfo("Az sum student i obicham da gotvq.");
		return Loren;
	}

	@GET
	@Path("/createRecipes")
	public void createRecipe() {
		new RecipesDao().create(this.recipeMusaka());
		new RecipesDao().create(this.recipeOrizSMeso());
		new RecipesDao().create(this.recipeSpaghetti());
	}

	@GET
	@Path("/Person")
	public void createUserRecipe() {
		new PersonDao().create(this.Loren());
	}

}
