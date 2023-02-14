package edu.temple.activity4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var textSizeSelector: RecyclerView
    lateinit var textSizeDisplay: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textSizeSelector = findViewById(R.id.textSizeSelectorRecyclerView)
        textSizeDisplay = findViewById(R.id.textSizeDisplayTextView)
        // Trying to create array of integers that are multiples of 5
        // Verify correctness by examining array values.
        val textSizes = Array(20){(it + 1) * 5}

        for(i in 0..textSizes.size)
            Log.d("Array values", textSizes[i].toString())

        textSizeSelector.adapter = TextSizeAdapter(textSizes)
        textSizeSelector.layoutManager = LinearLayoutManager(this)
    }
}
/* Convert to RecyclerView.Adapter */
class TextSizeAdapter(_textSizes: Array<Int>) : RecyclerView.Adapter<TextSizeAdapter.TextSizeViewHolder>() {
    private val texSizes = _textSizes
    class TextSizeViewHolder(view: TextView) : RecyclerView.ViewHolder (view) {
        val textView = view
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextSizeViewHolder {
        return TextSizeViewHolder(TextView(parent.context).apply { setPadding(5,20,0,20) })
    }
    override fun onBindViewHolder(holder: TextSizeViewHolder, position: Int) {
        holder.textView.text = texSizes[position].toString()
        holder.textView.textSize = texSizes[position].toFloat()
    }
    override fun getItemCount(): Int {
        return texSizes.size
    }
}