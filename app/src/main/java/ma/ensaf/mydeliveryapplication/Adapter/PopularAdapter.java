package ma.ensaf.mydeliveryapplication.Adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import ma.ensaf.mydeliveryapplication.Activity.ShowDetailActivity;
import ma.ensaf.mydeliveryapplication.Domain.FoodDomain;
import ma.ensaf.mydeliveryapplication.R;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {

    ArrayList<FoodDomain> popularFood;

    public PopularAdapter(ArrayList<FoodDomain> popularFood) {
        this.popularFood = popularFood;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflater= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular,parent,false);
        return new ViewHolder(inflater);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
         holder.title.setText(popularFood.get(position).getTitle());
         holder.fee.setText(String.valueOf(popularFood.get(position).getFee()));

         int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(popularFood.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());
         Glide.with(holder.itemView.getContext())
                 .load(drawableResourceId)
                 .into(holder.pic);
         holder.addBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent=new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
                 intent.putExtra("object", popularFood.get(position));
                 holder.itemView.getContext().startActivity(intent);
             }
         });

    }

    @Override
    public int getItemCount() {
        return popularFood.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,fee,addBtn;
        ImageView pic;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            title=itemView.findViewById(R.id.title);
            fee=itemView.findViewById((R.id.fee));
            pic=itemView.findViewById(R.id.pic);
            addBtn=itemView.findViewById(R.id.addBtn);
        }
    }

}
