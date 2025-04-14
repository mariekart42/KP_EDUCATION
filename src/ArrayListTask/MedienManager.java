package ArrayListTask;

import java.util.ArrayList;

public class MedienManager {
    private ArrayList<Object> _medien;


    public ArrayList<Object> get_medien() {
        if (this._medien == null)
        {
            this._medien = new ArrayList<Object>();
        }
        return _medien;
    }

    public void set_medien(ArrayList<Object> _medien) {
            this._medien = _medien;
    }

    void add(Object object)
    {
        ArrayList<Object> lol = get_medien();
        lol.add(object);
        set_medien(lol);
    }
}
