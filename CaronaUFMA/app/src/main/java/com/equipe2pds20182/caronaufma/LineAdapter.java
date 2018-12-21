package com.equipe2pds20182.caronaufma;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LineAdapter extends RecyclerView.Adapter<LineHolder> {

    private final List <Carona> mUsers;

    public LineAdapter(List users) {
        mUsers = users;
    }

    @Override
    public LineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LineHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_holder, parent, false));
    }

    @Override
    public void onBindViewHolder(LineHolder holder, int position) {
        /*holder.title.setText(String.format(Locale.getDefault(), "%s, %d - %s",
                //mUsers.get(position).getName(),
                //mUsers.get(position).getAge(),
                //mUsers.get(position).getCity()
        ));*/
        holder.nome.setText(mUsers.get(position).modeloDoCarro);
        holder.title.setText(mUsers.get(position).chegada);
        //holder.nome.setText(String.format(Locale.getDefault(),"me ajuda deus"));
        //holder.title.setText(mUsers.get(position).modeloDoCarro);
        //holder.moreButton.setOnClickListener(view -> updateItem(position));
        //holder.deleteButton.setOnClickListener(view -> removerItem(position));
    }

    @Override
    public int getItemCount() {
        return mUsers != null ? mUsers.size() : 0;
    }

    public void updateList(List user) {
        insertItem(user);
    }

    // Método responsável por inserir um novo usuário na lista e notificar que há novos itens.
    private void insertItem(List user) {
        mUsers.add((Carona) user);
        notifyItemInserted(getItemCount());
    }
}
