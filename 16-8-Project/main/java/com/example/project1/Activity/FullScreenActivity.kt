package com.example.project1.Activity

import android.app.DownloadManager
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import com.example.project1.R
import com.example.project1.databinding.ActivityCategoryBinding
import com.example.project1.databinding.ActivityFullScreenBinding
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import java.io.ByteArrayOutputStream
import java.lang.Exception

class FullScreenActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityFullScreenBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityFullScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val i: Intent = getIntent()
        var originalUrl = i.getStringExtra("image_position")!!
        Picasso.get().load(originalUrl).into(binding.photo)

        binding.imgDownload.setOnClickListener()
        {
            var manager:DownloadManager= getSystemService(DOWNLOAD_SERVICE) as DownloadManager
            var uri= Uri.parse(originalUrl)
            var request:DownloadManager.Request =DownloadManager.Request(uri)
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            manager.enqueue(request)
            Toast.makeText(applicationContext,"Downloading start",Toast.LENGTH_LONG).show()
        }
        binding.imgShare.setOnClickListener()
        {
            Picasso.get().load(originalUrl).into(object:Target{
                override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {

                    shareprepareintent(bitmap!!)


                }

                override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {

                }

                override fun onPrepareLoad(placeHolderDrawable: Drawable?) {

                }
            })
        }

    }

    private fun shareprepareintent(bitmap: Bitmap)
    {
        val shareIntent = Intent()
        shareIntent.setAction(Intent.ACTION_SEND)
        shareIntent.putExtra(Intent.EXTRA_STREAM,getImageUri(this,bitmap))
        shareIntent.putExtra(Intent.EXTRA_TEXT,"Hey there" + "https://www.tops-int.com")
        shareIntent.setType("image/*")
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        startActivity(Intent.createChooser(shareIntent, "Share Opportunity"))

    }

    private fun getImageUri(fullScreenActivity: FullScreenActivity, bitmap: Bitmap): Uri?
    {
        val bytes = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
        val path: String = MediaStore.Images.Media.insertImage(fullScreenActivity.contentResolver, bitmap, "Greetings", null)
        return Uri.parse(path)

    }
}