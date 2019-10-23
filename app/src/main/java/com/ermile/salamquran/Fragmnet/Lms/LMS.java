package com.ermile.salamquran.Fragmnet.Lms;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ermile.salamquran.Actitvty.Lms.Level_List;
import com.ermile.salamquran.Actitvty.Quran;
import com.ermile.salamquran.Function.api.LMS_api;
import com.ermile.salamquran.Item.item_LMS.GroupList;
import com.ermile.salamquran.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LMS extends Fragment {

    private RecyclerView recylerview_LMS;
    private LinearLayoutManager LayoutManager;
    private ArrayList<GroupList> item_groupList;

    public LMS() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragment_LMS = inflater.inflate(R.layout.fragment_lms, container, false);


        item_groupList = new ArrayList<>();


        recylerview_LMS = fragment_LMS.findViewById(R.id.fragmentLMS_RecyclerView);
        Adaptor Adaptors = new Adaptor(item_groupList,this.getContext());
        LayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        setGroupList();
        recylerview_LMS.setAdapter(Adaptors);





        return fragment_LMS;
    }


    private void setGroupList(){
        LMS_api.getGroupList(getContext(),new LMS_api.groupListListener() {
            @Override
            public void onGetGroupList(String token) {
                /*"id": "3",
                        "title": "ناس تا زلزال",
                        "type": null,
                        "desc": "آموزش سوره‌های ناس تا زلزال",
                        "sort": "1",
                        "status": "enable",
                        "datecreated": "2019-07-26 16:27:17",
                        "file": "https://salamquran.com/static/siftal/images/default/logo.png"*/
                try {
                    JSONArray jsonArray = new JSONArray(token);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        int id = jsonObject.getInt("id");
                        String title = jsonObject.getString("title");
                        String desc = jsonObject.getString("desc");
                        String file = jsonObject.getString("file");

                        item_groupList.add(new GroupList(id,title,"",desc,"","","",file));
                        recylerview_LMS.setLayoutManager(LayoutManager);
                        recylerview_LMS.setItemAnimator(new DefaultItemAnimator());

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onErrorGroupList(String error) {

            }
        });
    }

    private class Adaptor extends RecyclerView.Adapter<Adaptor.MyViewHolder> {

        List<GroupList> itemList;
        Context context;

        public Adaptor(List<GroupList> itemList, Context context) {
            this.itemList = itemList;
            this.context = context;
        }

        @Override
        public Adaptor.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View aView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lms_gruoplist, parent, false);
            return new Adaptor.MyViewHolder(aView);

        }

        @Override
        public void onBindViewHolder(final Adaptor.MyViewHolder holder, final int position) {
            final GroupList aItem = itemList.get(position);

            holder.titel.setText(aItem.getTitle());
            holder.desc.setText(aItem.getDesc());
            Glide.with(context)
                    .load(aItem.getFile())
                    .into(holder.image);
//            holder.image.setba(aItem.getFile());
            holder.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final Intent open_LevelList = new Intent(context, Level_List.class);/*Intent for Go to Page Quran*/
                    open_LevelList
                            .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                            .putExtra("id", aItem.getId());
                    context.startActivity(open_LevelList);

                }
            });

        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView titel,desc;
            ImageView image;

            MyViewHolder(View itemView) {
                super(itemView);
                image = itemView.findViewById(R.id.item_groupList_2_imageView);
                titel = itemView.findViewById(R.id.item_groupList_3_title);
                desc = itemView.findViewById(R.id.item_groupList_4_desc);
            }
        }

    }

}