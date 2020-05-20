package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_video_media_controller.*


class VideoController : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_video_media_controller, container, false);

        val chooseButton = view.findViewById(R.id.button) as Button
        val clickListenerChoose = View.OnClickListener {view ->
            chooseFile(view);
        }
        chooseButton.setOnClickListener(clickListenerChoose)

        val playButton = view.findViewById(R.id.button2) as Button
        val clickListenerPlay = View.OnClickListener {view ->
            play(view);
        }
        playButton.setOnClickListener(clickListenerPlay)

        val stopButton = view.findViewById(R.id.button3) as Button
        val clickListenerStop = View.OnClickListener {view ->
            stop(view);
        }
        stopButton.setOnClickListener(clickListenerStop)

        val pauseButton = view.findViewById(R.id.button4) as Button
        val clickListenerPause = View.OnClickListener {view ->
            pause(view);
        }
        pauseButton.setOnClickListener(clickListenerPause)

        return view
    }

    private fun chooseFile(view: View)
    {

        val intent = Intent()
        intent.setType("video/*")
        intent.setAction(Intent.ACTION_GET_CONTENT)
        startActivityForResult(intent, 101)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && data != null)
        {
            if(requestCode == 101)
            {
                 val uri = data.data!!
                 videoPlayer.setVideoURI(uri)
            }
        }
    }
    fun play(view: View?) {
        videoPlayer.start()
    }

    fun pause(view: View?) {
        videoPlayer.pause()
    }

    fun stop(view: View?) {
        videoPlayer.stopPlayback()
        videoPlayer.resume()
    }
}
