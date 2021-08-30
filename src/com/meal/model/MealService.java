package com.meal.model;

public class MealService {

	MealDAO_interface dao = new MealDAO();

	public MealVO addMeal(Integer diaryNo, Integer mealName, Double mealCal, Double mealCho, Double mealPro,
			Double mealFat) {

		MealVO meal = new MealVO();

		meal.setDiaryNo(diaryNo);
		meal.setMealName(mealName);
		meal.setMealCal(mealCal);
		meal.setMealCho(mealCho);
		meal.setMealPro(mealPro);
		meal.setMealFat(mealFat);

		dao.insert(meal);
		return meal;
	}

	public MealVO updateMeal(Integer mealNo, Integer diaryNo, Integer mealName, Double mealCal, Double mealCho,
			Double mealPro, Double mealFat) {

		MealVO meal = new MealVO();

		meal.setMealNo(mealNo);
		meal.setDiaryNo(diaryNo);
		meal.setMealName(mealName);
		meal.setMealCal(mealCal);
		meal.setMealCho(mealCho);
		meal.setMealPro(mealPro);
		meal.setMealFat(mealFat);

		dao.update(meal);
		return meal;
	}

	public void deleteMeal(Integer mealNo) {
		MealVO meal = new MealVO();

		meal.setMealNo(mealNo);

		dao.delete(meal);
	}

	public MealVO findByDiaryNo(int diaryNo) {

		return dao.findByDiaryNo(diaryNo);
	}

}
