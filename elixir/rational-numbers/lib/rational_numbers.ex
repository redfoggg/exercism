defmodule RationalNumbers do
  @type rational :: {integer, integer}

  @doc """
  Add two rational numbers
  """
  @spec add(a :: rational, b :: rational) :: rational
  def add(a, b) do
    den = Kernel.abs(elem(b, 0) * elem(b, 1))
    num = elem(a, 0) * elem(b, 1) + elem(a, 1) * elem(b, 0)

    cond do
      num == 0 -> {0, 1}
      true -> {num, den}
    end
  end

  @doc """
  Subtract two rational numbers
  """
  @spec subtract(a :: rational, b :: rational) :: rational
  def subtract(a, b) do
    den = Kernel.abs(elem(b, 0) * elem(b, 1))
    num = elem(a, 0) * elem(b, 1) - elem(a, 1) * elem(b, 0)

    cond do
      num == 0 -> {0, 1}
      true -> {num, den}
    end
  end

  @doc """
  Multiply two rational numbers
  """
  @spec multiply(a :: rational, b :: rational) :: rational
  def multiply(a, b) do
    num = elem(a, 0) * elem(b, 0)
    den = elem(a, 1) * elem(b, 1)
    new_rational = {num, den}
    reduce(new_rational)
  end

  @doc """
  Divide two rational numbers
  """
  @spec divide_by(num :: rational, den :: rational) :: rational
  def divide_by(num, den) do
    a = elem(num, 0) * elem(den, 1)
    b = elem(num, 1) * elem(den, 0)
    new_rational = {a, b}
    reduce(new_rational)
  end

  @doc """
  Absolute value of a rational number
  """
  @spec abs(a :: rational) :: rational
  def abs(a), do: reduce({Kernel.abs(elem(a, 0)), Kernel.abs(elem(a, 1))})

  @doc """
  Exponentiation of a rational number by an integer
  """
  @spec pow_rational(a :: rational, n :: integer) :: rational
  def pow_rational(a, n) when n < 0, do: 
    reduce({Integer.pow(elem(a, 1), Kernel.abs(n)), Integer.pow(elem(a, 0), Kernel.abs(n))})
  def pow_rational(a, n), do: reduce({Integer.pow(elem(a, 0), n), Integer.pow(elem(a, 1), n)})

  @doc """
  Exponentiation of a real number by a rational number
  """
  @spec pow_real(x :: integer, n :: rational) :: float
  def pow_real(x, n) do
    num = elem(n, 0)
    den = elem(n, 1)
    root = num / den
    float = x / 1 # converte de Integer para Float
    Float.pow(float, root)
  end

  @doc """
  Reduce a rational number to its lowest terms
  """
  @spec reduce(a :: rational) :: rational
  def reduce(a) do
    gcd = Integer.gcd(elem(a, 0), elem(a, 1))
    num = trunc(elem(a, 0) / gcd)
    den = trunc(elem(a, 1) / gcd)

    cond do
      den < 0 -> {num * -1, Kernel.abs(den)}
      true -> {num, den}
    end
  end
end
