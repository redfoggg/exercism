defmodule CollatzConjecture do
  require Integer

  @doc """
  calc/1 takes an integer and returns the number of steps required to get the
  number to 1 when following the rules:
    - if number is odd, multiply with 3 and add 1
    - if number is even, divide by 2
  """
  @spec calc(input :: pos_integer()) :: non_neg_integer()
  def calc(input) when input > 0 and not Kernel.is_bitstring(input) do
    calc_loop(input, 0)
  end

  defp calc_loop(input, step) do
    if Integer.is_even(input), do: calc_even(input, step), else: calc_odd(input, step)
  end

  defp calc_even(input, step) do
    input
    |> Kernel./(2)
    |> trunc
    |> calc_loop(step + 1)
  end

  defp calc_odd(input, step) do
    if input == 1 do
      step
    else
      input
      |> convert_into_even
      |> calc_loop(step + 1)
    end
  end

  defp convert_into_even(number), do: 3 * number + 1 |> trunc
end
