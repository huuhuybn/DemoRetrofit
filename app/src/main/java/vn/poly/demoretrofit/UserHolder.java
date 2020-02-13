package vn.poly.demoretrofit;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class UserHolder extends RecyclerView.ViewHolder {


    public TextView textView;
    public UserHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textView);
    }
}
