import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
from datetime import datetime, timedelta

dates = pd.date_range('2016-10-03', '2016-10-07')
closing_prices = np.array([780.12, 785.45, 782.30, 789.80, 791.25])  # Примерные значения

plt.figure()

plt.plot(dates, closing_prices, marker='o', linestyle='-', linewidth=1,
         color='red', markersize=3, markerfacecolor='red',
         markeredgecolor='red', markeredgewidth=1)


plt.title('Closing Stock Value of Alphabet Inc.', fontsize=16, fontweight='bold', pad=20)
plt.xlabel('Date', fontsize=12, fontweight='bold')
plt.ylabel('Closing Value', fontsize=12, fontweight='bold')

plt.xticks(dates, [date.strftime('%Y-%m-%d') for date in dates])

plt.grid(True, linestyle='--',linewidth=0.8, color='red')
plt.grid(True, which='minor',linestyle='--', linewidth=0.4, color='red')

plt.minorticks_on()
plt.tight_layout()
plt.show()