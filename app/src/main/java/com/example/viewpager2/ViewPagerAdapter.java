package com.example.viewpager2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.List;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewHolder> {
    private LayoutInflater layoutInflater;
    private ViewPager2 viewPager2;


    private int[] pix = new int[]
            {
                    R.drawable.algeria, R.drawable.angola, R.drawable.benin, R.drawable.botswana,
                    R.drawable.burkina_faso, R.drawable.burundi, R.drawable.cameroon,
                    R.drawable.cape_verde, R.drawable.chad, R.drawable.comoros, R.drawable.cote_d_ivoire,
                    R.drawable.djibouti, R.drawable.egypt, R.drawable.eritrea, R.drawable.eswatini,
                    R.drawable.ethiopia,
                    R.drawable.gabon, R.drawable.gambia, R.drawable.ghana, R.drawable.guinea,
                    R.drawable.guinea_bissa,
                    R.drawable.kenya, R.drawable.lesotho, R.drawable.liberia, R.drawable.libya,
                    R.drawable.madagascar,
                    R.drawable.malawi, R.drawable.mali, R.drawable.mauritania, R.drawable.mauritius,
                    R.drawable.morocco,
                    R.drawable.mozambique, R.drawable.namibia, R.drawable.niger, R.drawable.nigeria,
                    R.drawable.reunion,
                    R.drawable.rwanda, R.drawable.senegal, R.drawable.seychlles, R.drawable.sierra_leone,
                    R.drawable.somalia,
                    R.drawable.south_africa, R.drawable.south_sudan, R.drawable.sudan, R.drawable.tanzania,
                    R.drawable.togo, R.drawable.uganda, R.drawable.tunisia, R.drawable.zambia,
                    R.drawable.zimbabwe
            };

    public ViewPagerAdapter(Context context, ViewPager2 viewPager2) {
        this.layoutInflater = LayoutInflater.from(context);
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public ViewPagerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.view_pager_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerAdapter.ViewHolder viewHolder, int i) {
        viewHolder.myImageView.setImageResource(pix[i]);
    }

    @Override
    public int getItemCount() {
        return pix.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView myImageView;
        Button button1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myImageView = itemView.findViewById(R.id.myImageView);
            button1 = itemView.findViewById(R.id.buton_1);
                button1.setText("B");
            
        }
    }
}
