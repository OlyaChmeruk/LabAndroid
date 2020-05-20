package com.example.myapplication

import android.app.Activity
import android.content.Context.AUDIO_SERVICE
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_audio_media_player.*


class AudioMediaPlayer : Fragment() {

    var mPlayer: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_audio_media_player, container, false)

        val chooseButton = view.findViewById(R.id.button9) as Button
        val clickListenerChoose = View.OnClickListener {view ->
            chooseFile(view);
        }
        chooseButton.setOnClickListener(clickListenerChoose)

        val playButton = view.findViewById(R.id.button6) as Button
        val clickListenerPlay = View.OnClickListener {view ->
            play(view);
        }
        playButton.setOnClickListener(clickListenerPlay)

        val pauseButton = view.findViewById(R.id.button7) as Button
        val clickListenerPause = View.OnClickListener {view ->
            pause(view);
        }
        pauseButton.setOnClickListener(clickListenerPause)

        val stopButton = view.findViewById(R.id.button8) as Button
        val clickListenerStop = View.OnClickListener {view ->
            stop(view);
        }
        stopButton.setOnClickListener(clickListenerStop)

        return view
    }

    fun play(view: View?) {
        mPlayer!!.start();
    }

    fun pause(view: View?) {
        mPlayer!!.pause();
    }

    fun stop(view: View?) {
        stopPlay()
    }

    fun stopPlay() {
        mPlayer!!.stop()
        try {
            mPlayer!!.prepare()
            mPlayer!!.seekTo(0)
        } catch (t: Throwable) {
            Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun chooseFile(view: View)
    {
        val intent = Intent()
        intent.setType("audio/*")
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
                mPlayer = MediaPlayer.create(context, uri);
                mPlayer!!.setOnCompletionListener { stopPlay() }
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        if (mPlayer!!.isPlaying()) {
           stopPlay()
        }
    }
}
