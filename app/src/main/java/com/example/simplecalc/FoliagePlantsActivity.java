package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class FoliagePlantsActivity extends AppCompatActivity {

    RecyclerView explore_onclick_recyclerview;
    List<String> plant_titles;
    List<Integer> plant_images;
    List<String> plant_sci;
    List<String> plant_desc;
    List<String> plant_type;
    FoliageAdapter exploreOnClickAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foliage_plants);

        explore_onclick_recyclerview = findViewById(R.id.foliage_onclick_recyclerview);
        plant_titles = new ArrayList<>();
        plant_images = new ArrayList<>();
        plant_sci = new ArrayList<>();
        plant_desc = new ArrayList<>();
        plant_type = new ArrayList<>();

        exploreOnClickAdapter = new FoliageAdapter(this, plant_titles, plant_sci, plant_images, plant_desc, plant_type);

        plant_images.add(R.drawable.monstera);
        plant_images.add(R.drawable.foliage_golden_pothos);
        plant_images.add(R.drawable.foliage_foliage_spider_plant);
        plant_images.add(R.drawable.foliage_swisscheese_plant);
        plant_images.add(R.drawable.foliage_lucky_bamboo);
        plant_images.add(R.drawable.foliage_philodendron);
        plant_images.add(R.drawable.foliage_zz_plant);
        plant_images.add(R.drawable.foliage_croton);


        plant_titles.add("Monstera Deliciosa");
        plant_titles.add("Golden Pothos");
        plant_titles.add("Spider Plant");
        plant_titles.add("Swiss Cheese Plant");
        plant_titles.add("Lucky Bamboo");
        plant_titles.add("Philodendron");
        plant_titles.add("ZZ Plant");
        plant_titles.add("Croton");

        plant_sci.add("Monstera deliciosa");
        plant_sci.add("Epipremnum aureum");
        plant_sci.add("Chlorophytum comosum");
        plant_sci.add("Monstera adansonii");
        plant_sci.add("Dracaena sanderiana");
        plant_sci.add("Philodendron");
        plant_sci.add("Zamioculcas zamiifolia");
        plant_sci.add("Maranta leuconeura");
        plant_sci.add("Codiaeum variegatum");

        plant_desc.add("Native to the rainforests of Central America, the big, bold Monstera deliciosa plant is also known as the \"split-leaf philodendron.\" This easy-to-grow climbing evergreen can be found in many designer spaces for its \"wow\" factor. Indoors, the plant has a moderate growth rate and can grow in height about 1 to 2 feet a year. Its naturally glossy large heart-shaped leaves have a characteristic split. You'll also spot intricate aerial roots growing out of the soil which benefit the plant by supporting the stems that hold leaves that can grow to 3 feet long.");
        plant_desc.add("Pothos is arguably one of the easiest houseplants to grow, even if you're someone who forgets to water your plants often enough. This trailing vine, native to the Solomon Islands in the South Pacific, has pointed, heart-shaped green leaves that are sometimes variegated with white, yellow, or pale green striations. Pothos is a good indoor plant year-round and will grow quickly, often adding between 12 to 18 inches of length in a month.");
        plant_desc.add("Despite their creepy-crawly’s name, spider plants are among the most popular houseplants to grow. When grown indoors, these warm-weather perennials will survive less-than-perfect conditions, and they are stunning if you can closely mimic their native tropical environment by providing warm temperatures and humid air. These plants grow rosettes of slender, gently arching leaves that can stretch from around 12 to 18 inches long. The leaves can be green or striped green and white. Mature plants regularly send out long stems that bear small, star-shaped flowers. If the flowers are fertilized, a small fruit form. Once the flowers fall off, tiny plantlets form in their place, which ultimately grow their own roots and can be snipped off to create new potted plants. Spider plants are moderately fast-growing plants that can be planted at any time as long as they are not exposed to frost.");
        plant_desc.add("The (Monstera adansonii) gets its common name from its large, heart-shaped leaves that develop holes as the plant ages (in a process called fenestration). This makes the leaves resemble Swiss cheese. Native to Central and South America, the Swiss cheese plant is a tropical perennial that's typically grown as an indoor plant. Like its cousin Monstera deliciosa (also referred to as the Swiss cheese plant), Monstera adansonii has a fast growth rate and a vining habit. But it will remain at a manageable size when grown in a container indoors. When cultivated as a houseplant, Swiss cheese plants are typically grown from young nursery plants and can be potted at any time. It's important to note that all parts of Monstera plants are toxic to pets, so be careful when growing them indoors.");
        plant_desc.add("Sculptural lucky bamboo plants have eye-catching shapes, swirls, or braided stalks, and are frequently spotted in offices and residences for the purpose of good feng shui. They can also be trained so that stalks grow straight as an arrow and are adorned with smallish, simple floppy green leaves. Though the plant looks like bamboo and grows fast like bamboo (it can grow well over a foot in six months), it's not related to it at all, and it's actually more of a succulent.");
        plant_desc.add("The Philodendron genus contains hundreds of species of beautiful foliage plants. Their leaves are typically large, green, and glossy, and philodendrons are great for adding a bit of their native tropical flair to your home. These popular houseplants are known for their easy growing habits, and there are two types of philodendrons to choose from: vining and non-climbing. The vining varieties grow several feet, usually requiring some support structure to climb on, such as a trellis or around a basket. Non-climbing varieties grow upright and are excellent foliage plants for containers. In general, philodendrons have a fast growth rate. Philodendrons are also a great plant choice to purify the air in your home. They’re best planted in the spring, but houseplants typically can be started with success at any time of year.");
        plant_desc.add("Low-maintenance zz plants are Zamioculcas zamiifolia, characterized by their shiny, wide, oval-shaped leaves that shoot upward and quickly grow in a home indoors. The plant natively grows in East Africa, namely Zanzibar and Tanzania. The plants are also called Zanzibar gems for their spotless, waxy leaves that are so deep green that sometimes, these plants are mistaken as artificial. ZZ plants are slow-growing plants that prefer bright, indirect sunlight. One of the benefits of zz plant is that it can thrive in many lighting conditions. If you plant or repot a zz, do it in the spring or summer when it's in an active growth phase. These plants are toxic to humans and animals if ingested");
        plant_desc.add("The croton plant (Codiaeum variegatum) has colorful variegated foliage and nearly limitless leaf forms. As evergreens in USDA hardiness zones 11 and 12, they are often grown outdoors as ornamental shrubs. In their native habitat, crotons like humid, warm conditions with dappled light and plentiful water. These plants are difficult to please indoors. Outdoor plants can reach 10 feet in height, but pot-grown specimens tend to be much smaller, making them suitable for permanent houseplants or indoor/outdoor container plants. Generally, croton grows relatively slowly, gaining less than 12 inches of height per growing season. When growing croton plants indoors, the primary challenge is maintaining the ideal temperature because if it is too cold, they start losing leaves. However, crotons are well worth the effort for their explosion of color. Croton can be planted any time of year, depending entirely on the temperatures remaining consistently 70 to 80 degrees Fahrenheit indoors, outdoors, or in a greenhouse.");


        plant_type.add("Climbing evergreen");
        plant_type.add("Vine");
        plant_type.add("Herbaceous, perennial");
        plant_type.add("Perennial");
        plant_type.add("Perennial shrub");
        plant_type.add("Perennial");
        plant_type.add("Tropical perennial");
        plant_type.add("Evergreen shrub");

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        explore_onclick_recyclerview.setLayoutManager(gridLayoutManager);
        explore_onclick_recyclerview.setHasFixedSize(true);
        explore_onclick_recyclerview.setAdapter(exploreOnClickAdapter);

    }
}