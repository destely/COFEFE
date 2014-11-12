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

    //������� ������������� ���������
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
            cofefe.setShortDescription("��� ����");
            cofefe.setDescription("��� ����, ���� ���� ��");
            cofefe.setImage("espr_robysta.jpg");
            list.add(cofefe);
        }
    */
        Cofefe robusta = new Cofefe();
        robusta.setId(0);
        robusta.setTitle("�������");
        robusta.setShortDescription("137 p./100 �.");
        robusta.setDescription("�������, ���������� ���� � ������� ����������� �������.\n" +
                "������������� ������������� ��������� �����, �������������� �� ���������.\n" +
                "����� ��������������� ��� ����, �� �������� ����� ������ ������������ ������� � ����� ������� ����� ����.\n" +
                "������ ����� ��������� � ����� ��� �������� �������� � ���������������� �������� �����.");
        robusta.setImage("espr_robysta.jpg");
        list.add(robusta);

        Cofefe ruanda = new Cofefe();
        ruanda.setId(1);
        ruanda.setTitle("Ruanda");
        ruanda.setShortDescription("639 p./100 �.");
        ruanda.setDescription("������ ������������ ���� ���� �� ������ ������ ��������. ������� �� ��������, � ������� �������" +
                " � �������, ������������ ��������� �������� � �������� ������.\n" +
                "����� �� �������, ����� ����� �������� �����. ����� ����, ����������� �� ������, ����� ��������� ������� �" +
                "���������� �������� �� �����. ������ ������ ������ ������������ � �����. " +
                "����� ���� �������� ������ � ���� ������������� ��� ������������� � �����. �� �������� ���������� ����" +
                " ����� � ������� 10 - 15 ����� �� 3� �������� �����. ����� ����� �� �������� ���� �� ���������.");
        ruanda.setImage("class_ruanda.jpg");
        list.add(ruanda);

        Cofefe galapagos = new Cofefe();
        galapagos.setId(2);
        galapagos.setTitle("���������");
        galapagos.setShortDescription("877 p./100 �.");
        galapagos.setDescription("    ���������� ���� ���� � ������������ ��������. ������� ���������� �� �������������" +
                " �����, ��������� ���� ���������� ��������.\n" +
                "��-�� ��������-������������� ������� ���� \"���������\" ��������� ����� ������� ������ ����, " +
                "� ���������� ����������� �������, ��� ���� �� ���� ���� � ������������ �������� ���������� " +
                "���������������� ���� (��� �������� � �������� �� �����).��� ����� ������ ��������� � ������� � ������ ������.");
        galapagos.setImage("elit_galapagos.jpg");
        list.add(galapagos);

        Cofefe kenia = new Cofefe();
        kenia.setId(3);
        kenia.setTitle("����� ���������");
        kenia.setShortDescription("411 p./100 �.");
        kenia.setDescription("������������ ����������� ���� ����. ����������� ������� �������� ������������� ���������" +
                " ���������������� �� ��������-��������� ��������, �� ����� ������ ����� �� ����� � �����������. �����������" +
                " ��� ���������� �������� � ������������� ����, �� �������  ������������� �������� ���������.\n" +
                "���� ���������� ��������. ����������, ������� �� ��������. � ������ ��������� �� ����� � ������ ��������� ������������.");
        kenia.setImage("class_kenia_superstar.jpg");
        list.add(kenia);

        Cofefe gimalay = new Cofefe();
        gimalay.setId(4);
        gimalay.setTitle("�������");
        gimalay.setShortDescription("915 p./100 �.");
        gimalay.setDescription("���������������� ����. ��� ������ - ��� ��������� ����� ���������� �������, ������� �����," +
                " � ����� ������� ���������.\n ���������������� ����� ����� ���� � ���, ��� ��� ����������� ���� ���� �������" +
                " ������ ��������, ����� ��������, � � ���������� ���������� ������, ������� ������ ���������������� �����������.");
        gimalay.setImage("elit_gimalay.jpg");
        list.add(gimalay);

        Cofefe kopi = new Cofefe();
        kopi.setId(5);
        kopi.setTitle("���� �����");
        kopi.setShortDescription("4 525 p./100 �.");
        kopi.setDescription("��� ���������, ����� ���������������� � ������� ���� � ����, ������� �������� ���������� �������.\n" +
                "������� � ����� �������� ������� �� �������� � ������ ���� � ��������������� ��� ������� ����. " +
                "����� ������������ ���� � ��� �� ��������� 450 ��, � ������ ��� ����� ������. ����� ���������" +
                " ���������� ��������, ����������� �� �����, ����������� ������ ����� ���������� ������������. ���� " +
                "�������� �� �� ������������ �������� �����.");
        kopi.setImage("elit_kopi_lyvak.jpg");
        list.add(kopi);

        Cofefe blu = new Cofefe();
        blu.setId(6);
        blu.setTitle("��� ����");
        blu.setShortDescription("297 p./100 �.");
        blu.setDescription("� ������ ������ 85% ������� � 15% �������.\n �����������, �������� � ��� ������ ����� ������" +
                "������ ����, ��� ���������� �������� ������� � �������. ������� �������� ������������ ������ � ���������� " +
                "��������, �� �� ����� ������� ��������. ������� �� � �������� � �������, ������� � ���������� ������������." +
                " ������ ��� �������� ���������� ��������, ������� ������� ����������.");
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
