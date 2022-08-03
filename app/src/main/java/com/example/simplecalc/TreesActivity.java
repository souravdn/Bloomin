package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class TreesActivity extends AppCompatActivity {

    RecyclerView explore_onclick_recyclerview;
    List<String> plant_titles;
    List<Integer> plant_images;
    List<String> plant_sci;
    List<String> plant_desc;
    List<String> plant_type;
    TreesAdapter exploreOnClickAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trees);

        explore_onclick_recyclerview = findViewById(R.id.trees_onclick_recyclerview);
        plant_titles = new ArrayList<>();
        plant_images = new ArrayList<>();
        plant_sci = new ArrayList<>();
        plant_desc = new ArrayList<>();
        plant_type = new ArrayList<>();

        exploreOnClickAdapter = new TreesAdapter(this, plant_titles, plant_sci, plant_images, plant_desc, plant_type);

        plant_images.add(R.drawable.tree_fiddleleaf_fig);
        plant_images.add(R.drawable.tree_areca_palm);
        plant_images.add(R.drawable.tree_dragon_tree);
        plant_images.add(R.drawable.tree_weeping_fig);
        plant_images.add(R.drawable.tree_norfolkisland_palm);
        plant_images.add(R.drawable.tree_rubber_tree);
        plant_images.add(R.drawable.tree_ponytail_palm);
        plant_images.add(R.drawable.tree_money_tree);
        plant_images.add(R.drawable.tree_bay_laurel);
        plant_images.add(R.drawable.tree_corn_plant);


        plant_titles.add("Fiddleleaf Fig");
        plant_titles.add("Areca Palm");
        plant_titles.add("Dragon Tree");
        plant_titles.add("Weeping Fig");
        plant_titles.add("Norfolk Island Pine");
        plant_titles.add("Rubber Tree");
        plant_titles.add("Ponytail Palm");
        plant_titles.add("Money Tree");
        plant_titles.add("Bay Laurel");
        plant_titles.add("Corn Plant");

        plant_sci.add("Ficus lyrata");
        plant_sci.add("Dypsis lutescens");
        plant_sci.add("Dracaena marginata");
        plant_sci.add("Ficus benjamina");
        plant_sci.add("Araucaria heterophylla");
        plant_sci.add("Ficus elastica");
        plant_sci.add("Beaucarnea recurvata");
        plant_sci.add("Pachira aquatica");
        plant_sci.add("Laurus nobilis");
        plant_sci.add("Dracaena fragrans");

        plant_desc.add("The fiddle-leaf fig (Ficus lyrata) is a popular indoor tree featuring very large, heavily veined, and glossy violin-shaped leaves that grow upright on a sleek trunk. A fiddle-leaf fig is perfect as a focal point of a room if you can situate it in a floor-standing container where the plant is allowed to grow to at least 6 feet tall. (Most indoor specimens reach around 10 feet tall.) It's a fairly fast grower and can be potted at any point in the year if you're like most gardeners acquiring a nursery plant to keep indoors.");
        plant_desc.add("It is hard to believe that the areca palm (Dypsis lutescens) is considered an endangered species in its native Madagascar.1 If you drive down almost any street in a warm stateside climate, you are likely to see dozens of these tall, attractive, clumping palms that look a lot like bamboo. These palms have smooth, sometimes golden trunks that are reminiscent of bamboo clumps. Their fronds are narrow and full, almost like bamboo leaves. When grown outdoors, they are often used as a privacy screen. These palms are also grown indoors as houseplants. They are best planted in the spring, and they have a slow to moderate growth rate.");
        plant_desc.add("Dracaena marginata, more commonly known as a dragon tree, is an attractive plant with green sword-like, red-edged leaves. Native to Madagascar, the eye-catching spiky tree is known as a great entry plant for household gardeners—it's easy to care for, drought-tolerant, and nearly indestructible. The slow-growing plant can be planted year-round and boasts tiny white flowers in the spring (though it rarely flowers indoors). This small tree will grow to about 20 feet in warm outdoor climates, but it is generally grown as a potted houseplant and kept pruned to 6 feet or less. Keep the dragon tree away from pets because it's toxic to animals if ingested.");
        plant_desc.add("Weeping fig (also known as the ficus tree) grows as a large broadleaf evergreen tree in tropical and subtropical climates, but it is more often grown as a houseplant in homes, offices, and featured in interior commercial landscaping. This elegant plant has slender branches that arch gracefully from a light gray trunk, with dense, glossy dark leaves. When grown indoors, the plants are normally pruned to keep them about 3 feet to 6 feet tall, and their trunks are sometimes braided for decorative appeal. It is a fast grower and may need to be repotted up to once per year, but do so in the early spring for best results. ");
        plant_desc.add("Norfolk Island pine is not an actual pine tree, but rather a relative of the monkey puzzle tree, and often cultivated as a landscape tree in subtropical climates in North America and grown indoors elsewhere. It has a very straight trunk and pleasingly symmetrical branches covered with short, inward-curving needles, also called leaves. In other regions, the slow-growing Norfolk Island pine is often grown as a living Christmas tree, frequently decorated with ribbons or ornaments. All too often, the tree is discarded after the holiday season, but it can easily be kept as a permanent foliage plant indoors or planted outdoors when it warms up in the spring.");
        plant_desc.add("Ficus elastica, also known as the rubber plant, is an unusual-looking varietal native to the tropics of Southeast Asia. This long-lived plant boasts oversized, oval-shaped leaves with a rich emerald hue and can grow quickly, reaching up to 100 feet tall in its natural habitat. It's not the easiest plant for beginners because it's not very forgiving if it doesn't get the care it needs. However, it's more often grown indoors as a houseplant, where it can be planted and cared for year-round, and its size is kept more manageable. When it comes to caring for a rubber plant, care is straightforward. It needs adequate light, moisture, and warmth (it is a tropical plant). Give it a southern or eastern exposure, but keep it several feet away from the windows, and you'll be rewarded with an exotic addition to your indoor plant collection.");
        plant_desc.add("The ponytail palm (Beaucarnea recurvata) makes a surprisingly interesting desktop plant, considering that when grown outdoors it can be a full-size tree that towers over homes. Despite the common name and the appearance of the foliage, this is not a true palm, but rather a member of the Asparagaceae family that includes edible asparagus. Indoors, these novel little trees are often grown in shallow pots, with a tuft of strappy green leaves emerging from a bulbous stem that seems to erupt from the soil. (The bulbous trunk is the source of one of its common names, \"elephant's foot.\") Given time and the right conditions, a small desktop plant will grow into respectable specimen plants, up to 6 feet in height or more. Ponytail palm is native to arid regions in Central America and is among the easiest of small trees to grow indoors. When planted outdoors, spring is the traditional planting time, though a ponytail palm can be planted at almost any time. This is a very slow-growing, long-lived species. It may take five years or more for a 1-foot-tall plant to double in size.");
        plant_desc.add("Money tree, also commonly referred to Guiana chestnut, is a species of tree native to Central and South America that has become an attractive houseplant thanks to its hardy nature. First popularized as a houseplant in Taiwan during the 1980s, the money tree is prominent among those who practice feng shui and is believed to create positive “chi,” or energy, in the home. This alone has made it a staple in offices, banks, and homes alike. Money trees are most commonly sold as small plants with a braided trunk made up of three, five, or seven stems. The trees are braided by nurseries when they are young and will continue to grow this way as they mature. Rarely are they started at home from seed, but if you do plan to plant the tree outdoors, you should start it from seed in the spring. The trees will grow quickly indoors or outdoors, often adding up to 24 inches a year in height.");
        plant_desc.add("The leaves of bay laurel are best known for their use as a kitchen seasoning, but bay laurel is actually an evergreen shrub or tree native to the Mediterranean area. It has large, pointed oval leaves that are deep, glossy green in color with a leathery texture. Its natural growth habit produces a medium- to large-sized tree with multiple stems that support a dense green pyramidal canopy. But this slow-growing plant willingly accepts heavy pruning, so you will just as often see it appearing as a shrub or container plant kept trimmed into a dense green mass. The size of potted plants are generally kept to four to six feet tall, while unpruned landscape plants can eventually grow from 30 to 60 feet tall. In the spring, bay laurel has small yellow flowers that develop into dark purple berries in the fall. The bay laurel is dioecious (which means that the plants have specific genders, male or female). Flowers on female plants must be pollinated by a nearby male bay laurel in order to produce berries. Bay Laurel is a slow-growing tree (a few inches per year) that is best planted in the spring.");
        plant_desc.add("The corn plant (Dracaena fragrans) is a tropical African evergreen tree popular in Europe as an indoor plant since the mid-1800s—and in the U.S. since the early 20th century. They grow fairly slowly, from thick canes or stems that produce long, narrow leaves like stalks of corn, growing upward. This growth habit also makes them look a lot like palm trees, which is why they’re sometimes called “false palms.” They make good houseplants because they are tall and narrow, typically only reaching around 4- to 6-feet tall in containers. These plants aren't high maintenance once you get their growing conditions right. Springtime is ideal for starting new plants, though you can typically pot nursery plants indoors any time of year. ");

        plant_type.add("Broadleaf evergreen");
        plant_type.add("Palm or cycad");
        plant_type.add("Broadleaf evergreen");
        plant_type.add("Evergreen tree usually grown as a houseplant");
        plant_type.add("Needled evergreen conifer");
        plant_type.add("Evergreen tree");
        plant_type.add("Broadleaf evergreen tree");
        plant_type.add("Tree");
        plant_type.add("Broadleaf evergreen shrub or tree");
        plant_type.add("Broadleaf, evergreen, shrub/tree");



        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        explore_onclick_recyclerview.setLayoutManager(gridLayoutManager);
        explore_onclick_recyclerview.setHasFixedSize(true);
        explore_onclick_recyclerview.setAdapter(exploreOnClickAdapter);
    }
}