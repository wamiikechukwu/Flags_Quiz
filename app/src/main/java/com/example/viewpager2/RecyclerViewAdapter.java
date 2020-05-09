package com.example.viewpager2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private onClickListener onClickListener;

    private int[] pix = new int[]
            {R.drawable.algeria, R.drawable.angola, R.drawable.benin, R.drawable.botswana,
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

    RecyclerViewAdapter(Context context,onClickListener onClickListener) {
        this.context = context;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder viewHolder, int i) {
        viewHolder.imageView.setImageResource(pix[i]);

    }

    @Override
    public int getItemCount() {
        return pix.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            imageView.setOnClickListener(this);
            
        }

        @Override
        public void onClick(View v) {

            //THE POSITION OF THE ITEM THAT WAS CLICKED IN THE RECYCLERVIEW
            int adapterPosition = getAdapterPosition();
            onClickListener.onItemClick(adapterPosition);
        }
    }

    public interface onClickListener {
        void onItemClick(int position);
    }
}
