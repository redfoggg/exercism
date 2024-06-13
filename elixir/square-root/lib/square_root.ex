defmodule SquareRoot do
  @doc """
  Calculate the integer square root of a positive integer
  """
  @spec calculate(radicand :: pos_integer) :: pos_integer
  def calculate(radicand) when radicand > 1, do: calculate(radicand, 1, radicand)

  def calculate(radicand) when radicand <= 1, do: radicand

  def calculate(radicand, left, right) do
    mid = Kernel.trunc((left + right)/2)

    mid_pow = mid * mid

    cond do
      mid_pow == radicand -> mid
      mid_pow < radicand -> calculate(radicand, mid, right)
      mid_pow > radicand -> calculate(radicand, left, mid)
    end
  end
end
