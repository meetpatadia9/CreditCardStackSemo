package com.ipsmeet.creditcardstacksemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.amyu.stack_card_layout_manager.StackCardLayoutManager
import com.ipsmeet.creditcardstacksemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val cardList = arrayListOf(R.drawable.img_2, R.drawable.img_1, R.drawable.img_3, R.drawable.img_4)
    lateinit var cardAdapter: CardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cardAdapter = CardAdapter(this@MainActivity, cardList)

        binding.recyclerViewCards.apply {
            layoutManager = StackCardLayoutManager(5)
            adapter = cardAdapter
        }

        val itemDecor = ItemTouchHelper(
            object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN, 0) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean = true.also { _ ->
                    val fromPos = viewHolder.adapterPosition
                    val toPos = target.adapterPosition
                    cardAdapter.notifyItemMoved(fromPos, toPos)
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {}
            })
        itemDecor.attachToRecyclerView(binding.recyclerViewCards)
    }

}