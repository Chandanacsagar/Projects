# Importing webdriver from selenium 
from selenium import webdriver 
# Load Libraries - Make sure to run this cell!
import pandas as pd
import numpy as np
import re, os
from string import printable
from sklearn import model_selection
import pandas as pd
import numpy as np
import seaborn as sns
import matplotlib.pyplot as plt
import joblib
import inputScript
from tensorflow.keras.models import load_model
import time

model= load_model('phishing.h5')
# Here chrome webdriver is used 
driver = webdriver.Chrome() 

# URL of the website 
url = "https://www.google.com/"
driver.get(url)
while(1):
    get_url = driver.current_url
    print(get_url)
            
    if(get_url != url):
        print("entered phishing detection")
        #print(get_url)
        #driver.get(url)
        #get_url = driver.current_url
        #print(get_url)
        url = get_url
        URLfeatures = inputScript.main(url)
        print (URLfeatures[0])
        data1=URLfeatures
        data = np.array(data1).reshape(1, -1)
        print(data)
        print("Phishing Website Detection")
        features = data#URLfeatures[0]#data #np.array([[1,1,-1,1,1,1,-1,1,-1,1,1,-1,1,0,1,1,1,1,0,1,1,1,1,1,-1,1,-1,1,-1,1]])
        phd=model.predict(features)[0]
        print(phd)
        time.sleep(10)
        if phd < 0.93:
            
            driver.get("http://localhost/phi/")
            get_url = driver.current_url
            url=get_url
        
           

print("phising website")
