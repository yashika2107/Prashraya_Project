// using System.Collections;
// using System.Collections.Generic;
// using UnityEngine;
// using UnityEngine.XR.ARFoundation;
// using UnityEngine.XR.ARSubsystems;

// [RequireComponent(typeof(ARRaycastManager))]

// public class TapToPlace : MonoBehaviour
// {
//     public GameObject gameobjecttoinsantiate;

//     private GameObject spawnedobject;

//     private ARRaycastManager _arRaycastManager ;
//     private Vector2 touchPosition;

//     static List<ARRaycastHit> hits = new List<ARRaycastHit>(); 

//     private void Awake()
//     {
//         _arRaycastManager = GetComponent<ARRaycastManager>();    
//     }

//     bool TryGettouchPosition(out Vector2 touchPosition)
//     {
//         if (Input.touchCount > 0)
//         {
//             touchPosition = Input.GetTouch(index: 0).position;
//             return true;
//         }


//         touchPosition = default;
//         return false;
//     }

//     void Update()
//     {
//         if(!TryGettouchPosition(out Vector2 touchPosition))
//             return;

//         if(_arRaycastManager.Raycast(touchPosition , hits, trackableTypes: TrackableType.PlaneWithinPolygon))
//         {
//             var hitPose = hits[0].pose;

//             if(spawnedobject == null)
//             {
//                 spawnedobject = Instantiate(gameobjecttoinsantiate , hitPose.position , hitPose.Rotation);
//             }
//             else
//             {
//                 spawnedobject.transform.position = hitPose.position;
//             }
//         }
//     }
// }

