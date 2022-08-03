package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class CactiActivity extends AppCompatActivity {

    RecyclerView explore_onclick_recyclerview;
    List<String> plant_titles;
    List<Integer> plant_images;
    List<String> plant_sci;
    List<String> plant_desc;
    List<String> plant_type;
    CactiAdapter exploreOnClickAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cacti);

        explore_onclick_recyclerview = findViewById(R.id.cacti_onclick_recyclerview);
        plant_titles = new ArrayList<>();
        plant_images = new ArrayList<>();
        plant_sci = new ArrayList<>();
        plant_desc = new ArrayList<>();
        plant_type = new ArrayList<>();

        exploreOnClickAdapter = new CactiAdapter(this, plant_titles, plant_sci, plant_images, plant_desc, plant_type);

        plant_images.add(R.drawable.succulents_snake_plant);
        plant_images.add(R.drawable.succulents_jade_plant);
        plant_images.add(R.drawable.succulents_desert_rose);
        plant_images.add(R.drawable.succulents_burros_tail);
        plant_images.add(R.drawable.succulents_prickly_pear);
        plant_images.add(R.drawable.succulents_jade_planthouse_leek);
        plant_images.add(R.drawable.succulents_jade_plantmoon_cactus);
        plant_images.add(R.drawable.aloevera);
        plant_images.add(R.drawable.succulents_christmas_cactus);


        plant_titles.add("Snake Plant");
        plant_titles.add("Jade Plant");
        plant_titles.add("Desert Rose");
        plant_titles.add("Burro’s Tail");
        plant_titles.add("Pricky Pear Cactus");
        plant_titles.add("House Leek");
        plant_titles.add("Moon Cactus");
        plant_titles.add("Aloe Vera");
        plant_titles.add("Christmas Cactus");

        plant_sci.add("Dracaena trifasciata");
        plant_sci.add("Adenium obesum");
        plant_sci.add("Sedum morganianum");
        plant_sci.add("Opuntia");
        plant_sci.add("Sempervivum tectorum");
        plant_sci.add("Gymnocalycium mihanovichii");
        plant_sci.add("Clivia miniata");
        plant_sci.add("Aloe barbadensis miller");
        plant_sci.add("Gymnocalycium mihanovichii");

        plant_desc.add("Snake plant is one of the most popular and hardy species of houseplants. The plant features stiff, sword-like leaves and can range anywhere from six inches to eight feet tall. Snake plants can vary in color although many have green-banded leaves and commonly feature a yellow border. These plants are easy to grow and, in many cases, are nearly indestructible. They will thrive in very bright light or almost dark corners of the house. Snake plants generally grow slowly in indoor light, but increasing its exposure to light will boost growth if it receives a few hours of direct sun. Planting and repotting is best done in the spring.");
        plant_desc.add("The jade plant is a popular succulent houseplant with fleshy, oval-shaped leaves and thick, woody stems that resemble tiny tree trunks. With just a bit of care, it can grow to be between 3 and 6 feet tall, but it does so slowly, growing about 2 inches a year. Native to South Africa, jade plants were once thought to bring good luck to their owners, so are often given as housewarming gifts. Because they're typically only grown indoors, they can be brought home or started at any time, either from a professional nursery or through propagation.");
        plant_desc.add("The desert rose is a slow-growing plant, only growing about 12 inches per year. It is often used as a bonsai plant thanks to its thick succulent trunk, thin and delicate leaves, and luscious, deep pink trumpeting flowers. It is native to Africa, the Middle East, and Madagascar. The desert rose is the only Adenium extensively hybridized to obtain different flower colors. In many tropical and warmer climates, it's a widely-used ornamental outdoor plant, and in cooler zones it is grown indoors. It's best planted in the spring, and it will die if exposed to frost and freezing temperatures. ");
        plant_desc.add("Burro’s tail is a popular and easy-to-grow succulent with rows of fleshy, tear-drop shaped leaves, blue-green in color. Native to Honduras and Mexico, mature specimens grow slow and steady but can reach trailing lengths of up to 4 feet long in six years' time (though the average length is closer to 24 inches). They are most commonly grown as potted plants, often suspended as hanging specimens. Indoors, the succulent can be planted and propagated year-round, while outdoors it does best planted in early spring. Red or pink flowers can emerge in late summer, though the plant rarely blooms indoors.");
        plant_desc.add("The prickly pear cactus is among the most widespread cactus genera in the U.S. With over 100 species, this plant is characterized by its spiny, flat, club-shaped pads. Many varieties have large, round spines, while others have tiny, hair-like barbs that detach upon contact. While cacti are generally known as warm-weather desert plants, there are some prickly pear species that are hardy as far north as USDA zone 4. Prickly pear is best planted outside in the spring after the threat of frost has passed. Some prickly pears produce fruits that are prized for their edibility, but the plant's growth rate is fairly slow and it can take three or four years before a new plant starts fruiting.");
        plant_desc.add("House Leek is a mat-forming succulent native to Europe and Africa. Its growth habit features fleshy pointed leaves arranged in rosettes. The parent rosette is the \"hen\" and the smaller rosettes that grow from it are the \"chicks.\" Over time, this ground-hugging plant with a fondness for sandy, gravelly soil will spread to form colonies 2 feet wide or more. Although typically grown for its interesting shape and succulent leaves (usually red, green, blue, gold, or copper), hens and chicks does sometimes flower on tall stalks. Hens and chicks has a moderately quick growth rate and is best planted in spring—however, if you'd like to grow new plants from seed, you may want to start them in pots in the fall so the young plants are ready to go into the garden in the spring. They also make a great houseplant");
        plant_desc.add("The moon cactus is a grafted specimen that is almost always grown as a potted plant rather than a garden specimen. The colorful red, orange, or yellow top (the scion) is Gymnocalycium mihanovichii. The lower green cactus host portion can be any number of species but is usually a Hylocereus cactus. It becomes known as a moon cactus when the pieces are joined. The main job of the lower cactus is to display the Gymnocalycium at an advantageous height. These plants rarely last more than a few years, since the upper scion and the lower rootstock portions grow at different rates, which eventually destroys the graft union between the two sections. However, it is not a difficult matter to separate the scion and graft it onto a new rootstock cactus. The best seasons for planting are spring or summer when faster growth is favored.");
        plant_desc.add("Aloe vera, commonly grown as a houseplant, is known for its leaves which contain a soothing gel used on sunburns and other skin irritations. With over 300 species (the most common being Aloe barbadensis miller), this tropical succulent features fleshy lance-shape leaves with jagged edges that grow out from a basal rosette. Given the right growing conditions, spiky flowers will appear on the end of stalks in shades of yellow, red, or orange. Young plants don’t generally flower, and aloe grown as a houseplant can take years to produce flower stalks. Still, this fast-growing succulent will reach its mature size in three to four years and produces pups that can be repotted or given as gifts to other plant lovers.");
        plant_desc.add("Jelly bean succulents (Sedum rubrotinctum) are evergreen, low-growing perennial succulents that are native to Mexico. Also commonly referred to as “pork and beans” or “banana cactus”, jelly bean succulents are a part of the Sedum genus in the family Crassulaceae. They look beautiful in succulent arrangements or grown on their own. Thanks to their sprawling growth habit, mature jelly bean succulents can also be used as ground cover. These cute succulents are a hybrid of Sedum pachyphyllum and Sedum stahlii and are characterized by small chubby leaves that turn bright red/bronze in hot, sunny conditions. They can be grown successfully indoors as a houseplant or outdoors in the warmer climates. In colder climates, jelly bean succulents can be container-grown outdoors in summer and overwintered indoors. As with most succulents, jelly bean succulents are low-maintenance and do not require much attention in order to thrive. This makes them perfect for beginners and neglectful gardeners alike! ");


        plant_type.add("Evergreen, perennial");
        plant_type.add("Succulent");
        plant_type.add("Succulent");
        plant_type.add("Perennial, succulent");
        plant_type.add("Perennial, succulent");
        plant_type.add("Perennial, succulent");
        plant_type.add("Perennial, succulent");
        plant_type.add("Perennial, succulent");
        plant_type.add("Perennial, succulent");


        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        explore_onclick_recyclerview.setLayoutManager(gridLayoutManager);
        explore_onclick_recyclerview.setHasFixedSize(true);
        explore_onclick_recyclerview.setAdapter(exploreOnClickAdapter);
    }
}