package a.SurlyProjectFinal;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class Mp3ListAdapter extends BaseAdapter {
    ArrayList<Mp3Model> arrayMp3List = null;
    Context context = null;
    private LayoutInflater inflater = null;
    private int layout = 0;

    public Mp3ListAdapter(Context context2, ArrayList<Mp3Model> array) {
        this.context = context2;
        this.arrayMp3List = array;
        this.inflater = (LayoutInflater) context2.getSystemService("layout_inflater");
        this.layout = R.layout.mp3_list_cell;
    }

    public int getCount() {
        return this.arrayMp3List.size();
    }

    public Object getItem(int i) {
        return this.arrayMp3List.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = this.inflater.inflate(this.layout, parent, false);
        }
        final int pos = position;
        Context context2 = this.context;
        View view = convertView;
        ((TextView) convertView.findViewById(R.id.mp3_list_title)).setText(this.arrayMp3List.get(pos).getTitle());
        ((TextView) convertView.findViewById(R.id.mp3_cell_detail_text)).setText(this.arrayMp3List.get(pos).getSinger());
        convertView.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                try {
                    Log.i("fimtrus", "pos : " + pos + "path : " + Mp3ListAdapter.this.arrayMp3List.get(pos).getFilePath());
                    MusicManager.getMusicManager().selectPlay(pos);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalStateException e2) {
                    e2.printStackTrace();
                }
            }
        });
        return convertView;
    }
}
