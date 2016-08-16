package myrecycleview.staggeredgridlayoutmanager.zmj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Product> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        //设置layoutManager
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        //设置adapter
        initData();
        MasonryAdapter adapter = new MasonryAdapter(this,productList);
        recyclerView.setAdapter(adapter);
        //设置item之间的间隔
        SpacesItemDecoration decoration = new SpacesItemDecoration(16);
        recyclerView.addItemDecoration(decoration);
        //

    }

    private void initData() {
        for (int i = 0; i < Constants.IMAGES.length; i++) {
            Product product = new Product();
            product.setImg(Constants.IMAGES[i]);
            product.setTitle("我是Android" + i);
            productList.add(product);
        }
    }
}
