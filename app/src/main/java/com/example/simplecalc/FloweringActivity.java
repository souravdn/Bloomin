package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class FloweringActivity extends AppCompatActivity {

    RecyclerView explore_onclick_recyclerview;
    List<String> plant_titles;
    List<Integer> plant_images;
    List<String> plant_sci;
    List<String> plant_desc;
    List<String> plant_type;
    FloweringAdapter exploreOnClickAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowering);

        explore_onclick_recyclerview = findViewById(R.id.flowering_onclick_recyclerview);
        plant_titles = new ArrayList<>();
        plant_images = new ArrayList<>();
        plant_sci = new ArrayList<>();
        plant_desc = new ArrayList<>();
        plant_type = new ArrayList<>();

        exploreOnClickAdapter = new FloweringAdapter(this, plant_titles, plant_sci, plant_images, plant_desc, plant_type);

        plant_images.add(R.drawable.flowering_moth_orchid);
        plant_images.add(R.drawable.anthurium);
        plant_images.add(R.drawable.african_violet);
        plant_images.add(R.drawable.flowering_gloxinia);
        plant_images.add(R.drawable.flowering_peace_lily);
        plant_images.add(R.drawable.flowering_begonia_rieger);
        plant_images.add(R.drawable.flowering_kaffir_lily);
        plant_images.add(R.drawable.flowering_bromeliad);
        plant_images.add(R.drawable.flowering_amaryllis);
        plant_images.add(R.drawable.flowering_poinsettia);


        plant_titles.add("Moth Orchid");
        plant_titles.add("Anthurium");
        plant_titles.add("African Violets");
        plant_titles.add("Gloxinia");
        plant_titles.add("Peace Lily");
        plant_titles.add("Rieger Begonia");
        plant_titles.add("Kaffir Lily");
        plant_titles.add("Bromeliads");
        plant_titles.add("Amaryllis");
        plant_titles.add("Poinsettia");

        plant_sci.add("Phalaenopsis");
        plant_sci.add("Anthurium");
        plant_sci.add("Saintpaulia");
        plant_sci.add("Sinningia");
        plant_sci.add("Spathiphyllum");
        plant_sci.add("Begonia x hiemalis");
        plant_sci.add("Clivia miniata");
        plant_sci.add("Bromelia");
        plant_sci.add("Perennial bulb");
        plant_sci.add("Euphorbia pulcherrima");

        plant_desc.add("Moth orchids, native only to the tropical regions of Asia and Australia, are mostly known for brightening up the indoor spaces of homes in the U.S. In fact, these exotic flowers are almost impossible to grow outdoors anywhere in continental North America. With thousands of orchids to choose from, orchids from the Phalaenopsis genus remain the most popular ones because they are a particularly good orchid choice for beginners. The flower stalks of these orchids grow from leaf joints, or axils, and often bear multiple flower buds, which can bloom for a month or more when properly cared for. Their long-lasting flowers are held on arching branches and open successively. A single multi-branching flower spike can have more than 20 flowers, and individual flowers can last for weeks.");
        plant_desc.add("Anthurium is a genus of around 1,000 perennial plants native to Central America, northern South America, and the Caribbean. While they can be grown outdoors in the garden in warm climates, anthurium is more often grown as houseplants or in greenhouses since they have particular care needs. They grow at a slow or moderate growth rate, depending on getting ample light without getting sunburned. Also called flamingo flower for their unique tropical shape, you can plant them year-round and they bloom throughout the year. The blooming varieties are distinctive for their colorful, heart-shaped waxy spathes and red or yellow tail-like flower spikes. Other varieties feature large-leaved, deeply veined foliage. This plant's long-lasting bright red, green, and white colors make them a popular centerpiece during the Christmas holidays. Many anthuriums are climbers, and all need high humidity and warmth to thrive");
        plant_desc.add("African violets are one of the world's most popular houseplants and for good reason. These compact, low-growing plants flower several times a year, and they are available in a multitude of leaf forms and colors. Don't be put off by their reputation for difficulty: providing you follow a few simple rules, African violets should thrive indoors. With a little experience, it's possible to keep them in flower nearly all year round and grow them to the size of dinner plates.");
        plant_desc.add("Gloxinia hybrids can give you quite a lot of bang for your buck. These 12-inch tall and fast-growing plants feature large, velvety leaves somewhat reminiscent of African violets with giant, ruffled, bell-shaped flowers in a range of bright colors. They are available as double and single flowers and create great centerpieces for tables or windowsills if the location is somewhat shady. The vast majority of gloxinia on the market today are hybrids of Sinningia speciosa. However, by crossing Sinningia speciosa with other plants from the Sinningia genus, such as Sinningia regina, breeders have been able to create a wonderful kaleidoscope of colors and flower forms, including striped and double flowers. Gloxinia is not especially hard to grow, and if you can grow African violets, you can be successful growing gloxinia. Outside of their hardiness zone, you can place or plant them outdoors in the spring.");
        plant_desc.add("Peace lilies are tropical species and hybrid from the Spathiphyllum genus that are a favorite flowering houseplant. A striking plant when used in mass display, the peace lily blooms in spring with long-lasting flower stalks that hover gracefully over the foliage. The plant has glossy oval leaves with points that emerge from the soil. A well-grown peace lily may bloom twice a year, resulting in several months of flowers. When grown in the garden in the tropical and subtropical climates where they are hardy, peace lilies are normally planted in the spring while it is still cool. As houseplants, they can be purchased and brought into the home at any time, though you will want to protect the plants from cold temperatures as you move them from the store to your home. They are moderate growers and will reach maturity in around three years. Peace lily plants are considered toxic to pets and humans.");
        plant_desc.add("Flowering begonias, also known as Rieger begonias, are beautiful flowering winter plants with creamy blooms in bright yellows, reds, pinks, and even white. They are fast-growing, and typically bred to bloom during the winter season and sold as disposable plants; the idea is to enjoy the bloom and throw them out after the season is over. But you needn't follow this rule: You can grow Rieger begonias year-round and enjoy their blooms next fall.");
        plant_desc.add("Few houseplants can boast blooms as vibrant as the kaffir lily. After your winter holiday when plants like poinsettias and amaryllis have faded, the Kaffir lily fills a gap when the days are short and spring still seems far off. Despite its exotic appearance, the Kaffir lily is easy to grow as a houseplant, producing large clusters of blooms in the dry environment of the typical home. This tropical perennial can also be grown as an outdoor landscape plant in USDA zones 10 to 11, where it is often massed in large drifts, much the way daylilies are used. The Clivia genus is a member of the Amaryllidaceae family of plants, a group that includes the amaryllis—the popular winter houseplant. They can be introduced into the home as potted nursery plants at any time; if planted in the garden in warm climates, they are best planted at any time other than the hottest part of summer. These slow-growing plants can take several years to flower when they are planted from seeds.");
        plant_desc.add("The showy bromeliad may look difficult to grow, but it can easily adapt to average home conditions with its astonishing array of colors and textures. Although many do have very splashy flower displays, bromeliads are just as popular as beautiful foliage plants, with leaves in red, green, purple, orange, and yellow colors and with bands, stripes, spots, and other features. Bromeliads are relatively slow-growing plants that take one to three years to mature into flowering plants.");
        plant_desc.add("Amaryllis with its beautiful, large, funnel-shaped cluster of flowers in stunning colors does not have to be a one-and-done flower. Once amaryllis have finished blooming, there is no need to throw them out. With proper care after the bloom, you can keep amaryllis blooming for years. Usually, amaryllis are sold as potted houseplants or bulbs around the holidays. Making amaryllis rebloom the next year, and even year after year, is not difficult, it just takes some planning and extra care, first and foremost an adjustment of the watering schedule and the right temperature. Because the bloom of this tropical plant is controlled by moisture, which is entirely in your hands, you can set the time for when you want your amaryllis to bloom next.");
        plant_desc.add("Poinsettias remain one of the most popular holiday plants, synonymous with Christmas décor and festive cheer. The familiar red plant, native to Mexico, has been joined by even flashier hues thanks to hybridizers who have expanded the range of colors from the familiar scarlet to white, cream, salmon, yellow, and pink. The poinsettia plant is actually a shrub, Its blooms are a cluster of tiny yellow flowers surrounded by large brilliant (usually red) floral bracts, which are modified leaves. Also known as Mexican flameleaf, these plants are forced into bloom in time for the holiday season, and they require specific care to look their best into the new year and beyond.");

        plant_type.add("Perennial, herbaceous");
        plant_type.add("Herbaceous perennial");
        plant_type.add("Herbaceous perennial ");
        plant_type.add("Tropical Perennial");
        plant_type.add("Flowering tropical plant");
        plant_type.add("Perennial");
        plant_type.add("Perennial");
        plant_type.add("Perennial bulb");
        plant_type.add("Perennial, shrub");

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        explore_onclick_recyclerview.setLayoutManager(gridLayoutManager);
        explore_onclick_recyclerview.setHasFixedSize(true);
        explore_onclick_recyclerview.setAdapter(exploreOnClickAdapter);
    }
}