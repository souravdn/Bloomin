package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ClickOnExploreActivity extends AppCompatActivity {

    RecyclerView explore_onclick_recyclerview;
    List<String> plant_titles;
    List<Integer> plant_images;
    List<String> plant_sci;
    List<String> plant_desc;
    List<String> plant_type;
    ExploreOnClickAdapter exploreOnClickAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_on_explore);

        explore_onclick_recyclerview = findViewById(R.id.explore_onclick_recyclerview);
        plant_titles = new ArrayList<>();
        plant_images = new ArrayList<>();
        plant_sci = new ArrayList<>();
        plant_desc = new ArrayList<>();
        plant_type = new ArrayList<>();

        exploreOnClickAdapter = new ExploreOnClickAdapter(this, plant_titles, plant_sci, plant_images, plant_desc, plant_type);

        plant_images.add(R.drawable.rose);
        plant_images.add(R.drawable.bougainvillea);
        plant_images.add(R.drawable.jasmine);
        plant_images.add(R.drawable.bigleaf_hydrangea);
        plant_images.add(R.drawable.ming_alalia);
        plant_images.add(R.drawable.ixora);
        plant_images.add(R.drawable.cape_honeysuckle);
        plant_images.add(R.drawable.duranta);
        plant_images.add(R.drawable.gardenia);
        plant_images.add(R.drawable.song_of_india);

        plant_titles.add("Rose");
        plant_titles.add("Bougainvillea");
        plant_titles.add("Jasmine");
        plant_titles.add("Bigleaf Hydrangea");
        plant_titles.add("Ming Aralia");
        plant_titles.add("Ixora");
        plant_titles.add("Cape Honeysuckle");
        plant_titles.add("Duranta");
        plant_titles.add("Gardenia");
        plant_titles.add("Song of India");

        plant_sci.add("Rosa");
        plant_sci.add("Bougainvillea");
        plant_sci.add("Jasminum polyanthum");
        plant_sci.add("Hydrangea Macrophylla");
        plant_sci.add("Polyscias fruticosa");
        plant_sci.add("Ixora coccinea");
        plant_sci.add("Tecoma capensis");
        plant_sci.add("Duranta erecta");
        plant_sci.add("Gardenia jasminoides");
        plant_sci.add("Dracaena reflexa");

        plant_desc.add("Rose bushes (Rosa) have a reputation for being finicky plants, but some of this may stem from rose lovers' obsession with perfection—producing the ultimate blooms each season. In reality, roses are pretty tough survivors and will thrive with little to no care. But it certainly is true that roses like a little pampering and will reward your extra efforts with vigorous growth and spectacular flowers. Well-maintained plants also tend to have fewer of the common rose problems, such as mildew or winter damage. For most roses, spring is the most important time for tending to roses, getting them in ship shape for the growing—and blooming—season.");
        plant_desc.add("Bougainvillea is not your typical houseplant—in its natural state, it's a sprawling climber and shrub with formidable thorns, often found on the exterior of buildings (like climbing up a trellis or over a fence) or in gardens in subtropical-to-tropical climates. Native to South America, bougainvillea was named in honor of Louis Antoine de Bougainville, a sailor and explorer during the late 1700s. Best planted in the spring, bougainvillea is a quick grower, often adding more than 36 inches in length per year. It's known for its green foliage and vibrant pink, purple, and orange hues that most people assume are the plant's flowers—however, they're actually petal-like bracts that hide bougainvillea's true blooms, which are typically small white or yellow buds.");
        plant_desc.add("The Jasminum genus includes about 200 species of broadleaf evergreens and shrubs native to warm regions of Asia and Eurasia. Indoors or outdoors, the heavenly scent of flowering jasmine is greatly appreciated. When grown as houseplants, the vining jasmines vary in difficulty, but one popular species for growing indoors is the pink jasmine (Jasminum polyanthum), which is also known by the common names white jasmine, Chinese jasmine, or winter-blooming jasmine. Deep green glossy pinnate leaves grow on twining branches up to 20 feet long. In late winter, this fast-growing vine produces a profusion of reddish-pink buds in dense clusters that transform into star-shaped white flowers tinged with pink. Such ample blooming is unusual among houseplants.");
        plant_desc.add("With dozens of species and even more varieties, hydrangeas (Hydrangea spp.) have been popular ornamental garden plants for decades with blooms that come in a wide array of colors, including white, many shades of blue and pink, maroon, red, and even pale green. Some hydrangeas have large, round flower heads while others have smaller, flatter, and more delicate flowers, along with varying foliage shapes depending on the species. To ensure that hydrangea shrubs have time to establish a healthy root system, plant them in the fall or early spring. Hydrangeas are rapid growers, averaging two feet or more of growth per year.");
        plant_desc.add("Native to the tropics of India and Polynesia, Ming aralia is an interesting and exotic houseplant that is technically an evergreen shrub. While it is a bit more temperamental to grow than your average plant, it's well worth the effort for its fluffy, bright green foliage. Its ferny, feathery leaves droop from graceful narrow branches that grow straight up, forming a many-layered, complex plant. Ming aralia grows slowly just like false aralia but can eventually reach over 6 feet in height with the proper care. While it can be considered an outdoor ornamental shrub in USDA hardiness zones 11 and 12, it's most commonly cared for indoors, where it can be planted and grown year-round.");
        plant_desc.add("Ixora is an unusual houseplant and one that attracts attention the moment someone sets foot in your house. Native to Asia, Ixora plants are actually small shrubs that grow in subtropical regions, making them unsuitable for outdoor growth in much of the country. Started and grown year-round indoors, ixora plants feature large clusters of red, yellow, white, or orange flowers that emerge like puffballs from the evergreen leaves continuously throughout the year. Although they are relatively easy to grow outdoors under the right conditions, keeping an ixora plant happy and blooming inside can be a challenge even for an experienced gardener. In either location, the plant will grow slowly, so patience is the key if you're hoping for an oversized shrub.");
        plant_desc.add("Cape honeysuckle (Tecoma capensis) is a rambling broadleaf evergreen shrub, native to South Africa, often grown in warm climates as a flowering shrub or liana, where its blazing orange hues provide winter color and sweet nectar attract hummingbirds. Common name aside, this is not a true honeysuckle (Linicera spp.), but rather a close relative of trumpet creeper, belonging to the same Bignoniaceae family. This easy-to-grow plant has pinnately compound leaves with five to nine diamond-shaped leaflets. As a shrub, it grows up to 10 feet tall, but it can also ramble as a climbing vine as much as 30 feet or more. From fall to spring, it produces clusters of trumpet-shaped yellow, apricot, red, or orange flowers. It is a fast-grower that can grow anywhere from 13- to 25-inches tall in its first year after a successful spring planting.");
        plant_desc.add("Duranta plant, also widely known as golden dewdrops, is a tropical broadleaf evergreen that is often grown as an annual outdoor shrub or potted houseplant outside its zone 10—11 hardiness range. A member of the verbena family, duranta plant typically grows 2 to 4 feet tall in regions where it dies back in the winter, but it can achieve heights of 15 feet or more in warm-winter environments. Duranta plant has attractive evergreen foliage with rounded or oval leaves about 2 inches long; some varieties have gold or variegated leaves. It delivers scores of pale blue, white, or violet blossom clusters for the entire growing season. A bonus is the appearance of drooping clusters of yellow or orange berries in the fall. Normally planted in the spring, a duranta plant quickly becomes a small flowering shrub in its first season, and in warm climates, it can grow to a small tree size within a few years.");
        plant_desc.add("Gardenia (Gardenia jasminoides), a tropical broadleaf evergreen shrub, is typically grown as a large, indoor houseplant because its blooms smell magnificent. In fact, few natural scents are as evocative and memorable as the smell of this coveted plant. If it wasn't for the plant's fragrant appeal, however, few gardeners would attempt to grow the high-maintenance gardenia, commonly found only in conservatories and commercial greenhouses. Still, if you're up for the challenge, even a few months of blooms make it a worthwhile endeavor. Gardenia can also be planted outdoors in the spring or fall in the southern United States, or along the Pacific Coast. Gardeners typically purchase mature potted specimens for this purpose, so that they will bloom immediately. Should you choose to grow gardenia from seed, expect to wait two to three years before the plant flowers.");
        plant_desc.add("Song of India (Dracaena reflexa) is a tropical tree native to islands of the Indian Ocean, including Mozambique, Madagascar, and Mauritius. This popular plant can be grown indoors, and thanks to its easy growth habits, it's a great choice for beginner plant parents (just keep in mind that it's toxic to pets like dogs and cats). It has alternating dark green and chartreuse stripes on narrow, lanceolate leaves with veins that run parallel along their length. These leaves are in a whorled arrangement, gradually dying off to reveal a stem with an interesting pattern. This broadleaf evergreen will often grow 12 to 20 feet tall in the wild, but it can be an adaptable plant when grown indoors. It will suit your needs as either a tabletop or floor specimen. As a houseplant, Song of India will reach a maximum height of 3 to 6 feet. It's best to plant this species during the spring growing season, and plant parents can expect it to grow about 4 inches each year. If you choose to grow Song of India, you'll be rewarded with a beautiful, slow-growing plant that is easy to grow and propagate from cuttings.");

        plant_type.add("Deciduous shrub");
        plant_type.add("Perennial shrub");
        plant_type.add("Vine, perennial");
        plant_type.add("Deciduous shrub");
        plant_type.add("Evergreen shrub ");
        plant_type.add("Flowering evergreen shrub");
        plant_type.add("Tropical evergreen shrub");
        plant_type.add("Tropical evergreen shrub");
        plant_type.add("Flowering evergreen shrub");
        plant_type.add("Perennial shrub");

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        explore_onclick_recyclerview.setLayoutManager(gridLayoutManager);
        explore_onclick_recyclerview.setHasFixedSize(true);
        explore_onclick_recyclerview.setAdapter(exploreOnClickAdapter);
    }
}