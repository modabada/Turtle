import os

from numpy import expand_dims, vstack
from tensorflow.keras.models import load_model
from tensorflow.keras.preprocessing.image import load_img, img_to_array
import time
import cv2


if __name__ == "__main__":
    model = load_model("Turtle_AI.h5")


    def useModel():
        cv2.imwrite("./test.jpg", frame)
        dataset = load_img(path="./test.jpg", color_mode="rgb", target_size=(180, 180))
        dataset = img_to_array(dataset)
        dataset = expand_dims(dataset, axis=0)
        dataset = vstack([dataset])
        res = model.predict_classes(dataset)

        if res == [1]:
            print("거북목")
        elif res == [0]:
            print("거북목 아님")
        else:
            print(res)

        os.remove("./test.jpg")


    cam = cv2.VideoCapture(0)
    cam.set(cv2.CAP_PROP_FRAME_WIDTH, 320)
    cam.set(cv2.CAP_PROP_FRAME_HEIGHT, 180)

    if not cam.isOpened():
        exit()

    end = time.time() + 4
    while True:
        status, frame = cam.read()

        if not status:
            break

        cv2.imshow("Title", frame)
        if time.time() > end:
            end = time.time() + 4
            useModel()
        cv2.waitKey(33)

    cam.release()
    cv2.destroyAllWindows()
