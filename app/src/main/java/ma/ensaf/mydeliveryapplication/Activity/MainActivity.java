package ma.ensaf.mydeliveryapplication.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import ma.ensaf.mydeliveryapplication.Adapter.CategoryAdapter;
import ma.ensaf.mydeliveryapplication.Adapter.PopularAdapter;
import ma.ensaf.mydeliveryapplication.Domain.CategoryDomain;
import ma.ensaf.mydeliveryapplication.Domain.FoodDomain;
import ma.ensaf.mydeliveryapplication.R;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapter,adapter2;
private RecyclerView recyclerviewcategorylist,recyclerviewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerVeiwCategory();
        recyclerviewpopular();
        bottonNavigation();
        setmenu();

    }

    private void bottonNavigation(){
        FloatingActionButton floatingActionButton=findViewById(R.id.cartBtn);
        LinearLayout homeBtn=findViewById(R.id.HomeBtn);
        LinearLayout profileBtn=findViewById(R.id.ProfileBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ProfileActivity.class));
            }
        });
    }
    private void recyclerVeiwCategory(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerviewcategorylist=findViewById(R.id.recyclerView);
        recyclerviewcategorylist.setLayoutManager(linearLayoutManager);
        ArrayList<CategoryDomain> category=new ArrayList<CategoryDomain>();
        category.add(new CategoryDomain("Pizza","cat_1"));
        category.add(new CategoryDomain("Burger","cat_2"));
        category.add(new CategoryDomain("Hotdog","cat_3"));
        category.add(new CategoryDomain("Drink","cat_4"));
        category.add(new CategoryDomain("Donut","cat_5"));

        adapter=new CategoryAdapter(category);
        recyclerviewcategorylist.setAdapter(adapter);
    }
    private void recyclerviewpopular(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerviewPopularList=findViewById(R.id.recyclerView2);
        recyclerviewPopularList.setLayoutManager(linearLayoutManager);
        ArrayList<FoodDomain> foodList=new ArrayList<FoodDomain>();
        foodList.add(new FoodDomain("Pepperoni pizza","pop_1","slices pepperoni,mozzerella chese,fresh oregano,ground black pepper,pizza sauce",9.76));
        foodList.add(new FoodDomain("Chese Berger","pop_2","beef,Gouda Cheese, Special Sauce,Lettuce, tomato",8.79));
        foodList.add(new FoodDomain("Vegetable pizza","pop_3","olive oil,vegetable oil,pitted kalamata,cherry tomatoes,fresh oregano,basil",8.5));
        adapter2 =new PopularAdapter(foodList);
        recyclerviewPopularList.setAdapter(adapter2);
    }

//menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
            super.onBackPressed();
    }

    public void setmenu(){
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home1:
                        startActivity(new Intent(MainActivity.this,MainActivity.class));

                    case R.id.contact:
                        startActivity(new Intent(MainActivity.this,MainActivity.class));

                    case R.id.gallery:
                        startActivity(new Intent(MainActivity.this,MainActivity.class));

                    case R.id.about:
                        startActivity(new Intent(MainActivity.this,ProfileActivity.class));

                    case R.id.login:
                        startActivity(new Intent(MainActivity.this,MainActivity.class));

                    case R.id.share:
                        startActivity(new Intent(MainActivity.this,MainActivity.class));

                    case R.id.rate_us:
                        startActivity(new Intent(MainActivity.this,MainActivity.class));
                }
                return false;
            }
        });
    }

}