package com.github.marcelobenedito.mynewyorkcity.data

import com.github.marcelobenedito.mynewyorkcity.R
import com.github.marcelobenedito.mynewyorkcity.data.model.Category
import com.github.marcelobenedito.mynewyorkcity.data.model.Place


// Coffee Shops
val coffeeShops = listOf(
    Place("Stumptown Coffee Roasters", "18 W 29th St", "Meticulously sourced beans from around the world.", R.drawable.stumptown_coffee_roasters),
    Place("Blue Bottle Coffee", "450 W 15th St", "Minimalist haven known for freshness and quality.", R.drawable.blue_bottle_coffee),
    Place("Joe Coffee Company", "405 W 23rd St", "Cozy spot with a commitment to sustainability.", R.drawable.joe_coffee_company),
    Place("Toby's Estate Coffee", "44 Charles St", "Laid-back vibe with specialty brews and pastries.\n\nThe story of Toby's Estate began in 1997, when coffee-loving lawyer Toby Smith made a life-changing decision, swapping legal books for coffee cups to follow his passion for his favourite brew. Travelling to some of the most remote corners of the globe, Toby lived amongst the coffee-producing communities, experiencing first-hand the lifelong dedication and hard manual labour that went into growing their exquisite beans.\n\nToby knew that connoisseurs and everyday drinkers would love the specialty coffee as much as he did – but how to get the beans from crop to cafés?", R.drawable.tobys_estate_coffee),
    Place("La Colombe Coffee Roasters", "400 Lafayette St", "Rustic charm with a focus on unique blends.", R.drawable.la_colombe_coffee_roasters)
)

// Restaurants
val restaurants = listOf(
    Place("Katz's Delicatessen", "205 E Houston St", "Iconic deli famous for pastrami sandwiches.",),
    Place("Shake Shack", "Madison Square Park, E 23rd St & Madison Ave", "Modern twist on classic American fast food."),
    Place("Gramercy Tavern", "42 E 20th St", "Warm atmosphere with a seasonal and innovative menu."),
    Place("Levain Bakery", "167 W 74th St", "Haven for cookie enthusiasts with gooey delights."),
    Place("Di Fara Pizza", "1424 Avenue J, Brooklyn", "Legendary pizzeria hailed as one of the best.")
)

// Kid-Friendly Places
val kidFriendlyPlaces = listOf(
    Place("Central Park", "Manhattan, NY", "Vast playground with green spaces and a zoo."),
    Place("American Museum of Natural History", "Central Park West & 79th St", "Exciting and educational exhibits for children."),
    Place("Children's Museum of the Arts", "103 Charlton St", "Hands-on artistic experience for young ones."),
    Place("Bronx Zoo", "2300 Southern Blvd, Bronx", "Wildlife haven with exhibits from around the globe."),
    Place("Chelsea Piers", "62 Chelsea Piers", "Sports and entertainment complex for active fun.")
)

// Parks
val parks = listOf(
    Place("Central Park", "Manhattan, NY", "Iconic green oasis with diverse recreational activities."),
    Place("High Line Park", "Elevated park with stunning views and landscaped gardens.", "Unique retreat above the city's hustle."),
    Place("Prospect Park", "95 Prospect Park West, Brooklyn", "Natural beauty and recreational opportunities."),
    Place("Bryant Park", "6th Ave & W 42nd St", "Vibrant urban oasis with lush greenery and events."),
    Place("Washington Square Park", "5 Ave, Waverly Pl, W 4th St", "Greenwich Village landmark with a lively atmosphere.")
)

// Shopping Centers
val shoppingCenters = listOf(
    Place("Fifth Avenue", "Manhattan, NY", "Luxury shopping district with flagship stores."),
    Place("SoHo", "Manhattan, NY", "Trendy neighborhood with fashionable boutiques."),
    Place("The Shops at Columbus Circle", "10 Columbus Cir", "Sophisticated shopping experience with stunning views."),
    Place("Chelsea Market", "75 9th Ave", "Food and shopping haven in a historic building."),
    Place("Westfield World Trade Center", "185 Greenwich St", "Modern shopping destination with high-end and mainstream brands.")
)

val categories = listOf(
    Category(name = "Coffee Shop", places = coffeeShops, imageResourceId = R.drawable.coffee_shop),
    Category(name = "Restaurant", places = restaurants, imageResourceId = R.drawable.restaurants),
    Category(name = "Kid-Friendly Place", places = kidFriendlyPlaces, imageResourceId = R.drawable.kid_frendly_place),
    Category(name = "Park", places = parks, imageResourceId = R.drawable.parks),
    Category(name = "Shopping Center", places = shoppingCenters, imageResourceId = R.drawable.shopping_center),
)
