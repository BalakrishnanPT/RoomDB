package mock.roomdb.example_MVP.View

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.chandru.roomlibrary.RecyclerView.ReViewAdapter
import mock.roomdb.R
import mock.roomdb.data.db.UserKt
import mock.roomdb.example_MVP.Model.ModelLoadKt
import mock.roomdb.example_MVP.Presenter.ImageViewPresenterImpl

class ImageViewActivity : AppCompatActivity(), ImageView, View.OnClickListener {

    private lateinit var imageViewPresenter: ImageViewPresenterImpl
    private val TAG = "IV_View"
    private var button: Button? = null
    private var name: EditText? = null
    private var region: EditText? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var modelLoadKt: ModelLoadKt
    private lateinit var li: List<UserKt>
    private lateinit var mReViewAdapter : ReViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_view)
        button = findViewById(R.id.btn_click)
        imageViewPresenter = ImageViewPresenterImpl(this, ModelLoadKt(this))
        button!!.setOnClickListener(this)
        name = findViewById(R.id.name)
        region = findViewById(R.id.region)
        modelLoadKt = ModelLoadKt(this)
        recyclerView = findViewById(R.id.rv_room)
        val reLayoutManager = LinearLayoutManager(applicationContext)
        reLayoutManager.reverseLayout = true
        reLayoutManager.stackFromEnd = true
        recyclerView.layoutManager = reLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        li = modelLoadKt.load()
        mReViewAdapter = ReViewAdapter(this,li)
        recyclerView.adapter = mReViewAdapter
           }

    override fun onClick(v: View) {
        val id = v.id
        when (id) {
            R.id.btn_click -> imageViewPresenter.newText(name!!.text.toString(), region!!.text.toString())
        }
    }
    override fun buttonOnclick(list: List<UserKt>) {
                    mReViewAdapter.refresh(list)
                   recyclerView.scrollToPosition(list.size-1)
                    Log.d("TESTING",li?.size.toString())
    }
}
