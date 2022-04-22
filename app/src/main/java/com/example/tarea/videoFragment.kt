package com.example.tarea

import android.R
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment
import com.example.tarea.databinding.FragmentVideoBinding
import kotlinx.android.synthetic.main.fragment_video.*
import kotlin.io.path.Path


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [videoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class videoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentVideoBinding? = null
    private val binding get() = _binding!!
    private var videoView: VideoView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_video, container, false)

        _binding = FragmentVideoBinding.inflate(inflater, container, false)
        val root: View = binding.root

        videoView = idvideo

        setupRawVideo();

        return root
    }


    private fun setupRawVideo() {

        val video = Path("R.raw.hyun")
        val videoPath = "android.resource://" + requireContext().packageName + "/" + video
        val uri = Uri.parse(videoPath)
        videoView?.setVideoURI(uri)
        val mediaController = MediaController(activity)
        videoView?.setMediaController(mediaController)
        mediaController.setAnchorView(videoView)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment videoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            videoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}