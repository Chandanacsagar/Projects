
#importing basic packages
import pandas as pd
import numpy as np
import seaborn as sns
import matplotlib.pyplot as plt
import joblib
import inputScript

 
 

URLfeatures = inputScript.main("https://google.com")
print (URLfeatures[0])
data=URLfeatures
data = np.array(data).reshape(1, -1)
print(data)
