package net.zabalburu.mcdonalds.servicio;

import java.util.ArrayList;
import java.util.List;

import net.zabalburu.mcdonalds.modelo.Producto;

public class Servicio {
	private List<Producto> productos = new ArrayList<>();
	
	public Servicio() {
		productos.add(new Producto("Beef & Pork","Big Mac",530,10,48,85,28));
		productos.add(new Producto("Beef & Pork","Quarter Pounder with Cheese",520,12,61,95,31));
		productos.add(new Producto("Beef & Pork","Quarter Pounder with Bacon & Cheese",600,13,63,105,34));
		productos.add(new Producto("Beef & Pork","Quarter Pounder with Bacon Habanero Ranch",610,13,64,105,35));
		productos.add(new Producto("Beef & Pork","Quarter Pounder Deluxe",540,11,54,85,28));
		productos.add(new Producto("Beef & Pork","Double Quarter Pounder with Cheese",750,19,96,160,53));
		productos.add(new Producto("Beef & Pork","Hamburger",240,3,15,30,10));
		productos.add(new Producto("Beef & Pork","Cheeseburger",290,5,27,45,15));
		productos.add(new Producto("Beef & Pork","Double Cheeseburger",430,10,52,90,30));
		productos.add(new Producto("Beef & Pork","Bacon Clubhouse Burger",720,15,75,115,38));
		productos.add(new Producto("Beef & Pork","McDouble",380,8,40,75,25));
		productos.add(new Producto("Beef & Pork","Bacon McDouble",440,10,49,90,30));
		productos.add(new Producto("Beef & Pork","Daily Double",430,9,44,80,27));
		productos.add(new Producto("Beef & Pork","Jalapeño Double",430,9,44,80,27));
		productos.add(new Producto("Beef & Pork","McRib",500,10,48,70,23));
		productos.add(new Producto("Chicken & Fish","Premium Crispy Chicken Classic Sandwich",510,3.5,18,45,16));
		productos.add(new Producto("Chicken & Fish","Premium Grilled Chicken Classic Sandwich",350,2,9,65,22));
		productos.add(new Producto("Chicken & Fish","Premium Crispy Chicken Club Sandwich",670,9,44,85,29));
		productos.add(new Producto("Chicken & Fish","Premium Grilled Chicken Club Sandwich",510,7,36,105,35));
		productos.add(new Producto("Chicken & Fish","Premium Crispy Chicken Ranch BLT Sandwich",610,6,31,70,24));
		productos.add(new Producto("Chicken & Fish","Premium Grilled Chicken Ranch BLT Sandwich",450,4.5,22,90,30));
		productos.add(new Producto("Chicken & Fish","Bacon Clubhouse Crispy Chicken Sandwich",750,10,51,90,31));
		productos.add(new Producto("Chicken & Fish","Bacon Clubhouse Grilled Chicken Sandwich",590,8,42,110,37));
		productos.add(new Producto("Chicken & Fish","Southern Style Crispy Chicken Sandwich",430,3,15,45,14));
		productos.add(new Producto("Chicken & Fish","McChicken",360,3,15,35,11));
		productos.add(new Producto("Chicken & Fish","Bacon Cheddar McChicken",480,7,35,65,21));
		productos.add(new Producto("Chicken & Fish","Bacon Buffalo Ranch McChicken",430,5,25,50,17));
		productos.add(new Producto("Chicken & Fish","Buffalo Ranch McChicken",360,3,16,35,11));
		productos.add(new Producto("Chicken & Fish","Premium McWrap Chicken & Bacon (Crispy Chicken)",630,9,45,80,26));
		productos.add(new Producto("Chicken & Fish","Premium McWrap Chicken & Bacon (Grilled Chicken)",480,7,36,95,32));
		productos.add(new Producto("Chicken & Fish","Premium McWrap Chicken & Ranch (Crispy Chicken)",610,8,40,65,21));
		productos.add(new Producto("Chicken & Fish","Premium McWrap Chicken & Ranch (Grilled Chicken)",450,6,31,80,27));
		productos.add(new Producto("Chicken & Fish","Premium McWrap Southwest Chicken (Crispy Chicken)",670,8,40,60,21));
		productos.add(new Producto("Chicken & Fish","Premium McWrap Southwest Chicken (Grilled Chicken)",520,6,32,80,27));
		productos.add(new Producto("Chicken & Fish","Premium McWrap Chicken Sweet Chili (Crispy Chicken)",540,4.5,23,50,16));
		productos.add(new Producto("Chicken & Fish","Premium McWrap Chicken Sweet Chili (Grilled Chicken)",380,3,14,65,22));
		productos.add(new Producto("Chicken & Fish","Chicken McNuggets (4 piece)",190,2,10,25,9));
		productos.add(new Producto("Chicken & Fish","Chicken McNuggets (6 piece)",280,3,15,40,13));
		productos.add(new Producto("Chicken & Fish","Chicken McNuggets (10 piece)",470,5,25,65,22));
		productos.add(new Producto("Chicken & Fish","Chicken McNuggets (20 piece)",940,10,50,135,44));
		productos.add(new Producto("Chicken & Fish","Chicken McNuggets (40 piece)",1880,20,101,265,89));
		productos.add(new Producto("Chicken & Fish","Filet-O-Fish",390,4,19,40,14));
		productos.add(new Producto("Salads","Premium Bacon Ranch Salad (without Chicken)",140,3.5,18,25,9));
		productos.add(new Producto("Salads","Premium Bacon Ranch Salad with Crispy Chicken",380,6,29,70,23));
		productos.add(new Producto("Salads","Premium Bacon Ranch Salad with Grilled Chicken",220,4,20,85,29));
		productos.add(new Producto("Salads","Premium Southwest Salad (without Chicken)",140,2,9,10,3));
		productos.add(new Producto("Salads","Premium Southwest Salad with Crispy Chicken",450,4.5,22,50,17));
		productos.add(new Producto("Salads","Premium Southwest Salad with Grilled Chicken",290,2.5,13,70,23));
		productos.add(new Producto("Snacks & Sides","Chipotle BBQ Snack Wrap (Crispy Chicken)",340,4.5,22,30,11));
		productos.add(new Producto("Snacks & Sides","Chipotle BBQ Snack Wrap (Grilled Chicken)",260,3.5,18,40,14));
		productos.add(new Producto("Snacks & Sides","Honey Mustard Snack Wrap (Crispy Chicken)",330,4.5,22,35,11));
		productos.add(new Producto("Snacks & Sides","Honey Mustard Snack Wrap (Grilled Chicken)",250,3.5,18,45,14));
		productos.add(new Producto("Snacks & Sides","Ranch Snack Wrap (Crispy Chicken)",360,5,27,40,13));
		productos.add(new Producto("Snacks & Sides","Ranch Snack Wrap (Grilled Chicken)",280,4.5,22,45,16));
		productos.add(new Producto("Snacks & Sides","Small French Fries",230,1.5,8,0,0));
		productos.add(new Producto("Snacks & Sides","Medium French Fries",340,2.5,11,0,0));
		productos.add(new Producto("Snacks & Sides","Large French Fries",510,3.5,17,0,0));
		productos.add(new Producto("Snacks & Sides","Kids French Fries",110,1,4,0,0));
		productos.add(new Producto("Snacks & Sides","Side Salad",20,0,0,0,0));
		productos.add(new Producto("Snacks & Sides","Apple Slices",15,0,0,0,0));
		productos.add(new Producto("Snacks & Sides","Fruit 'n Yogurt Parfait",150,1,5,5,2));
		productos.add(new Producto("Desserts","Baked Apple Pie",250,7,35,0,0));
		productos.add(new Producto("Desserts","Chocolate Chip Cookie",160,3.5,19,10,3));
		productos.add(new Producto("Desserts","Oatmeal Raisin Cookie",150,2.5,13,10,3));
		productos.add(new Producto("Desserts","Kids Ice Cream Cone",45,1,4,5,2));
		productos.add(new Producto("Desserts","Hot Fudge Sundae",330,7,34,25,8));
		productos.add(new Producto("Desserts","Hot Caramel Sundae",340,5,24,30,10));
		productos.add(new Producto("Desserts","Strawberry Sundae",280,4,20,25,8));
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
}
