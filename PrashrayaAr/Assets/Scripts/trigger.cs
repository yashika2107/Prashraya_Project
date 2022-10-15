using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class trigger : MonoBehaviour
{

    public Animator anim;
    public Button yourButton;

    void Start () {
		Button btn = yourButton.GetComponent<Button>();
		btn.onClick.AddListener(play);
	}

    public void play(){

        anim.Play("airsquat");
        // Debug.Log("Hello: ");

    }

}
