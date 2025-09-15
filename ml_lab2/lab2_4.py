import matplotlib.pyplot as plt
import numpy as np


def complex_log_function(x):
    sin_sq = np.sin(x) ** 2
    tan_arg = 1 / (1 + sin_sq)
    base = 1 + np.tan(tan_arg)
    argument = (x ** 2 + 1) * np.exp(-np.abs(x) / 10)


    with np.errstate(divide='ignore', invalid='ignore'):
        result = np.log(argument) / np.log(base)

    return np.where(np.isfinite(result), result, np.nan)



x = np.linspace(-6, 6, 5000)
y = complex_log_function(x)

plt.figure(figsize=(14, 8))


valid_mask = np.isfinite(y)
plt.plot(x[valid_mask], y[valid_mask], linewidth=2.5, color='red')

plt.title(r'График: $\log_{1+\tan\left(\frac{1}{1+\sin^{2}(x)}\right)}\left[(x^{2}+1)e^{-\frac{|x|}{10}}\right]$',
          fontsize=16, pad=20)
plt.xlabel('x', fontsize=14)
plt.ylabel('f(x)', fontsize=14)
plt.grid(True, alpha=0.3)

plt.axvline(x=0, color='gray', linestyle='--', alpha=0.7)
plt.axhline(y=0, color='gray', linestyle='--', alpha=0.7)

plt.tight_layout()
plt.show()