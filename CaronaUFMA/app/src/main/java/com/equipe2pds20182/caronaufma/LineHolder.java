package com.equipe2pds20182.caronaufma;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class LineHolder extends RecyclerView.ViewHolder  {

    public TextView title,nome;

    public LineHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.textViewidHolder1);
        nome =  (TextView) itemView.findViewById(R.id.textViewIdHolder2);
    }
}
