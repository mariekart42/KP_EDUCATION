package ArrayListTask;

public class program {
    public static void main(String[] args) {
        MedienManager m = new MedienManager();
        m.add(new int[]{1, 3, 6});

        m.add(new String[]{"lol", "hehe"});

        for (Object lol : m.get_medien())
        {
            System.out.println(lol.getClass().getSimpleName());
        }
    }
}
