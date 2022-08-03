package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class HerbsActivity extends AppCompatActivity {

    RecyclerView explore_onclick_recyclerview;
    List<String> plant_titles;
    List<Integer> plant_images;
    List<String> plant_sci;
    List<String> plant_desc;
    List<String> plant_type;
    HerbsAdapter exploreOnClickAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_herbs);

        explore_onclick_recyclerview = findViewById(R.id.herbs_onclick_recyclerview);
        plant_titles = new ArrayList<>();
        plant_images = new ArrayList<>();
        plant_sci = new ArrayList<>();
        plant_desc = new ArrayList<>();
        plant_type = new ArrayList<>();

        exploreOnClickAdapter = new HerbsAdapter(this, plant_titles, plant_sci, plant_images, plant_desc, plant_type);

        plant_images.add(R.drawable.herbs_parsley);
        plant_images.add(R.drawable.herbs_lemongrass);
        plant_images.add(R.drawable.herbs_basil);
        plant_images.add(R.drawable.herbs_mint);
        plant_images.add(R.drawable.herbs_oregano);
        plant_images.add(R.drawable.cilantro);
        plant_images.add(R.drawable.herbs_thyme);
        plant_images.add(R.drawable.herbs_sage);
        plant_images.add(R.drawable.herbs_rosemary);
        plant_images.add(R.drawable.herbs_peppermint);


        plant_titles.add("Parsley");
        plant_titles.add("Lemongrass");
        plant_titles.add("Basil");
        plant_titles.add("Mint");
        plant_titles.add("Oregano");
        plant_titles.add("Cilantro");
        plant_titles.add("Thyme");
        plant_titles.add("Sage");
        plant_titles.add("Rosemary");
        plant_titles.add("Peppermint");

        plant_sci.add("Petroselinum crispum");
        plant_sci.add("Cymbopogon citratus");
        plant_sci.add("Ocimum basilicum");
        plant_sci.add("Mentha");
        plant_sci.add("Origanum vulgare");
        plant_sci.add("Coriandrum sativums");
        plant_sci.add("Thymus vulgaris");
        plant_sci.add("Salvia officinalis");
        plant_sci.add("Rosmarinus officinalis");
        plant_sci.add("Mentha piperita");

        plant_desc.add("Native to Europe, parsley is a biennial plant that is generally grown as an annual culinary herb. Growing in clumps of lacy foliage about a foot high, parsley has triangular dark green leaves that make for a good garnish or an aromatic addition to recipes. Best planted in the spring, most varieties of parsley grow fairly slowly, establishing maturity between 70 to 90 days after planting. Note that parsley is technically toxic both to people1 and pets2 due to chemical compounds found in it called furanocoumarins. Moreover, different varieties of parsley yield different flavors, so consider how you'd like to use the herb before choosing what to plant in your garden. For example, curly parsley is a little bitter for some palettes, while flat-leaf parsley (also known as Italian parsley) is more in favor with today’s cooks.");
        plant_desc.add("For gardeners looking to get the most bang for their buck, certain edible landscaping plants, such as lemongrass, can fulfill two desires. This ornamental grass increases curb appeal and offers tasty fresh herbs for the kitchen. Fast-growing lemongrass is as handsome waving in the summer breeze as it is appetizing in your soups, stir-fries, and teas. Native to Sri Lanka and India, just like the crossandra, lemongrass is perennial in zones 10 and 11 but is often grown as an annual in other regions. The long, slender gray-green foliage adds gorgeous color in autumn gardens when it turns burgundy and red. Lemongrass is best planted from potted nursery starts in spring, after all danger of frost has passed. Be aware that this plant contains cyanogenic glycosides and other oils that are mildly toxic to dogs, cats, and horses.");
        plant_desc.add("Basil plants are one of the most popular herbs to grow and also one of the easiest. Sweet basil (Ocimum basilicum) is a member of the mint family. It is closely identified with Italian cooking, although it is originally from India. The extremely aromatic leaves also have a delightful variety of flavors, from the slightly lemony-mint of sweet basil to cinnamon and licorice. Leaf colors span from rich green to deep purple, with smooth or crinkled leaves. The flowers are insignificant but very popular with bees. All types of basil grow easily in warm, sunny weather. The leaves are commonly used in cooking, but the flower buds are also edible. This fast-growing herb thrives equally well in gardens and containers. With sufficiently warm weather, new basil plants are ready for pruning (to encourage bushier growth) in about six weeks.");
        plant_desc.add("Mint species (Mentha spp.) are very hardy perennials that are simple to identify not just because of their fresh and spicy scent but because all members of the mint genus have opposite leaves and square stems. Long stems grow upward, flop over, and roots will form where the stems touch the soil enabling the mint plant to spread quite aggressively. Its small white or purple summer-blooming flowers attract bees, butterflies, and other pollinators. Mint plants grow quickly and should be planted in the spring after the threat of frost has passed. Mint is toxic to animals if it is ingested.");
        plant_desc.add("The Oreganum genus contains many perennial herbs and subshrubs that are native to western Asia and the Mediterranean region, though some have naturalized in North America. The most common species are familiar culinary herbs, including Origanum vulgare and Origanum majorana. Oregano leaves are generally oval, dark green, and positioned in opposite pairs along the stems. Some varieties have fuzzy leaves. Oregano starts as a ground-hugging rosette of leaves, but it can easily grow to about 2 feet tall. It's generally planted in the spring and grows quickly, providing leaves suitable for cooking almost immediately. Note that oregano is toxic to pets, so be mindful of where you plant it.");
        plant_desc.add("Cilantro (Coriandrum sativum) is a great addition to any herb garden. Not only is it a relatively easy plant to grow, but it actually boasts two cooking uses for the price of one. The name cilantro refers to the plant's thin, green stems and flat, lacy leaves, which are best eaten fresh. Its other common name, coriander, refers to the seeds, which are used as a common cooking spice, especially in Indian, Middle Eastern, and Asian cuisines. Cilantro is best planted in the early spring but also can be started in fall. It grows quickly, often yielding its first harvest of leaves within 30 days. Its seeds will be ready for harvest closer to three months from planting.");
        plant_desc.add("Thyme (Thymus vulgaris) is a low-growing, woody perennial that performs especially well in somewhat dry, sunny conditions. A beloved Mediterranean herb, it holds its taste in cooking and blends well with other flavors of its native region, such as garlic, olive oil, and tomatoes. The tiny pink, lavender, or white tubular flowers of thyme plants show up in the spring and summer months and are well-liked by bees. Its tiny gray-green leaves remain evergreen, and most thyme varieties can even be harvested in winter in the zones where it is a perennial. Thyme can be planted at almost any time. It will mature enough to allow for harvest within a few months, then will reliably return year after year in the climate zones where it is hardy. Providing a thick layer of mulch in colder regions helps protect thyme during the winter");
        plant_desc.add("Sage (Salvia officinalis) is one of the easiest perennial herbs to grow. Also known as culinary sage, this semi-shrubby plant features wooly, gray-green, aromatic, ovate leaves that stretch up to 4 inches long. The leaves are commonly used fresh or dried in cooking and add an earthy and slightly peppery flavor. Spikes of blue-purple flowers appear in the summertime. Sage can be planted in the spring or fall, and it has a moderate growth rate.");
        plant_desc.add("The rosemary plant (Salvia rosmarinus) is a fragrant herb that grows as a perennial rounded evergreen shrub. It features slender, needle-like, gray-green leaves on erect woody stems. And it produces clusters of small, light blue to white flowers typically in the late spring to early summer, though it can bloom at other points of the year as well. Plant rosemary in the spring after any threat of frost has passed. You can grow rosemary indoors, too, though it will grow quite large. The shrub has a moderate growth rate and spreads when planted.");
        plant_desc.add("Peppermint (Mentha × piperita) was initially considered to belong to its own species. However, it was later realized that the herb was, in fact, a hybrid between spearmint (Mentha spicata) and watermint (Mentha aquatica). This amazingly aromatic herb is one of the oldest herbs used for ritual, culinary, and medicinal purposes. Today it is used for aesthetics, being cherished for its lovely refreshing fragrance and taste.");

        plant_type.add("Herb, annual, biennial");
        plant_type.add("Perennial, annual, herb");
        plant_type.add("Perennial or annual herb");
        plant_type.add("Perennial, herb");
        plant_type.add("Annual, herb");
        plant_type.add("Herbaceous perennial");
        plant_type.add("Herb, perennial");
        plant_type.add("Herb, perennial");
        plant_type.add("Herbaceous perennial");
        plant_type.add("Herb, perennial");

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        explore_onclick_recyclerview.setLayoutManager(gridLayoutManager);
        explore_onclick_recyclerview.setHasFixedSize(true);
        explore_onclick_recyclerview.setAdapter(exploreOnClickAdapter);
    }
}