package main.java.ru.eltech.cofefe.core.provider;

import main.java.ru.eltech.cofefe.core.entity.Cofefe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


/**
 * Created by destely on 25.10.2014.
 */
public class CofefeProviderStub implements CofefeProvider {

    private static final Object monitor = new Object();

    private List<Cofefe> list = new ArrayList<>(20);

    private static volatile CofefeProviderStub instance = null;

    //ленивая инициализация синглтона
    public static CofefeProviderStub getInstance() {
        if (instance == null) {
            synchronized (monitor) {
                if (instance == null) {
                    instance = new CofefeProviderStub();
                }
            }
        }
        return instance;
    }

    private CofefeProviderStub() {
    /*    Random random = new Random();
        for(int i = 0; i < 10; i++) {
            Cofefe cofefe = new Cofefe();
            cofefe.setId(i);
            cofefe.setTitle("Cofefe [" + random.nextInt() + "]");
            cofefe.setShortDescription("Это кофе");
            cofefe.setDescription("Это кофе, кофе кофе фе");
            cofefe.setImage("espr_robysta.jpg");
            list.add(cofefe);
        }
    */
        Cofefe robusta = new Cofefe();
        robusta.setId(0);
        robusta.setTitle("Робуста");
        robusta.setShortDescription("137 p./100 г.");
        robusta.setDescription("Крупкий, насыщенный кофе в большим содержанием кофеина.\n" +
                "Неприхотливая разновидность кофейного зерна, произрастающая на равниннах.\n" +
                "Самый распостраненный вид кофе, из которого часто делают расстворимые крепкие и очень горькие сорта кофе.\n" +
                "Иногда также добавляют в смеси для придания крепости в сильнообжаренные эспрессо сорта.");
        robusta.setImage("espr_robysta.jpg");
        list.add(robusta);

        Cofefe ruanda = new Cofefe();
        ruanda.setId(1);
        ruanda.setTitle("Руанда");
        ruanda.setShortDescription("639 p./100 г.");
        ruanda.setDescription("Редкий эксклюзивный сорт кофе из Африки класса спешилти. Средний по крепости, с винными нотками" +
                " в аромате, послевкусием молочного шоколада с дольками лимона.\n" +
                "Зерно не крупное, имеет более округлую форму. Сорта кофе, привезенные из Африки, имеют цветочные оттенки и" +
                "деликатную кислинку во вкусе. Тонкий винный аромат завораживает и манит. " +
                "Такой кофе наиболее сильно и ярко расскрывается при приготовлении в турке. Во востчной технологии кофе" +
                " варят в течении 10 - 15 минут до 3х поднятий пенки. Очень важно не доводить кофе до выкипания.");
        ruanda.setImage("class_ruanda.jpg");
        list.add(ruanda);

        Cofefe galapagos = new Cofefe();
        galapagos.setId(2);
        galapagos.setTitle("Галапагос");
        galapagos.setShortDescription("877 p./100 г.");
        galapagos.setDescription("    Уникальный сорт кофе с Галапагоских островов. Бережно выращенный на вулканической" +
                " почве, зернойвой кофе насыщяется кофеином.\n" +
                "Из-за природно-климатических условий кофе \"Галапогос\" считается очень крепким сортом кофе, " +
                "с повышенным содержанием кофеина, при этом на вкус кофе с галапогоских островов уникальный " +
                "сбалансированный сорт (без кислинки и горчинки во вкусе).Это очень редкое сочетание у крепких у бодрых сортов.");
        galapagos.setImage("elit_galapagos.jpg");
        list.add(galapagos);

        Cofefe kenia = new Cofefe();
        kenia.setId(3);
        kenia.setTitle("Кения Суперстар");
        kenia.setShortDescription("411 p./100 г.");
        kenia.setDescription("Классический африканский сорт кофе. Африканская арабика обладает многогранными вкусовыми" +
                " характеристиками от фруктово-цветочных оттенков, до ярких винных ноток во вкусе и послевкисии. Обусловлено" +
                " это засушливым климатов и особенностями почв, на которых  расположились кофейные плантации.\n" +
                "Кофе наивысшего качества. Насыщенный, средний по крепости. С винной кислинкой во вкусе и долгим фруктовым послевкусием.");
        kenia.setImage("class_kenia_superstar.jpg");
        list.add(kenia);

        Cofefe gimalay = new Cofefe();
        gimalay.setId(4);
        gimalay.setTitle("Гималаи");
        gimalay.setShortDescription("915 p./100 г.");
        gimalay.setDescription("Сбалансированный вкус. Его аромат - это сочетание ноток цитрусовых фруктов, лесного ореха," +
                " а также пряного кориандра.\n Индивидуальность этого сорта кофе в том, что при заваривании кофе дает сначала" +
                " легкую горчинку, потом кислинку, а в результате получается долгое, немного пряное сбалансированние послевкусие.");
        gimalay.setImage("elit_gimalay.jpg");
        list.add(gimalay);

        Cofefe kopi = new Cofefe();
        kopi.setId(5);
        kopi.setTitle("Копи Лювак");
        kopi.setShortDescription("4 525 p./100 г.");
        kopi.setDescription("Это редчайший, самый экстраординарный и дорогой кофе в мире, имеющий поистине уникальную историю.\n" +
                "Занесен в Книгу рекордов Гиннеса за редкость – именно этим и обуславливается его высокая цена. " +
                "Объем производства кофе в год не превышает 450 кг, а купить его хотят многие. Такое небольшое" +
                " количество продукта, поступающее на рынок, объясняется прежде всего сложностью производства. Кофе " +
                "получают из не переваренных люваками зерен.");
        kopi.setImage("elit_kopi_lyvak.jpg");
        list.add(kopi);

        Cofefe blu = new Cofefe();
        blu.setId(6);
        blu.setTitle("Блю Стар");
        blu.setShortDescription("297 p./100 г.");
        blu.setDescription("В состав входят 85% арабики и 15% робусты.\n Традиционно, эспрессо — это всегда смесь разных" +
                "сортов кофе, так называемая «свадьба» арабики и робусты. Арабика обладает многогранным вкусом и изысканным " +
                "ароматом, но не имеет должной крепости. Робуста же — наоборот — горькая, крепкая и достаточно прямолинейна." +
                " Вдвоем они образуют мелодичную симфонию, любимую многими кофеманами.");
        blu.setImage("espr_blu_star.jpg");
        list.add(blu);
    }

    @Override
    public List<Cofefe> getAll() {
        return list;
    }

    @Override
    public List<Cofefe> search(String query) {
        List<Cofefe> result = new LinkedList<>();
        for (Cofefe cofefe : list) {
            if (cofefe.getTitle().toLowerCase().contains(query.toLowerCase())) {
                result.add(cofefe);
            }
        }
        return result;
    }

    @Override
    public Cofefe getById(Long id) {
        for (Cofefe cofefe : list) {
            if (cofefe.getId() == id) {
                return cofefe;
            }
        }
        return null;
    }

}
