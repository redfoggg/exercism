defmodule Triangle do
  @type kind :: :equilateral | :isosceles | :scalene

  @doc """
  Return the kind of triangle of a triangle with 'a', 'b' and 'c' as lengths.
  """
  @spec kind(number, number, number) :: {:ok, kind} | {:error, String.t()}
  def kind(a, b, c) when a <= 0 or b <= 0 or c <= 0 do
    {:error, "all side lengths must be positive"}
  end

  def kind(a, b, c) when a + b >= c and b + c >= a and c + a >= b do
    cond do
      a == b and c == b -> {:ok, :equilateral}
      (a == b and c != b) or (a == c and b != c) or (b == c and a != c) -> {:ok, :isosceles}
      true -> {:ok, :scalene}
    end
  end

  def kind(_a, _b, _c) do
    {:error, "side lengths violate triangle inequality"}
  end
end
